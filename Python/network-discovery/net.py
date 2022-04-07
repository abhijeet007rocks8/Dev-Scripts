import scapy.all as scapy
import argparse
import requests

def get_parser():
    parser = argparse.ArgumentParser(description="A local area network scanner.", usage="local_discover.py -i IFACE -a IPADDR Use -h|--help for a brief info.")
    parser.add_argument('-i', '--interface', type=str, nargs=1, required=True, help='The local area network adapter to scan upon.', dest='iface')
    parser.add_argument('-a', '--ip-address', type=str, nargs=1, required=True, default='0.0.0.0', help="IP address of the network in CIDR notation or a single IP of a device", dest='ipaddr')
    return parser.parse_args()

def get_mac_vendor(mac):
    mac = mac.split(':')[0:3]
    mac = ":".join(mac)
    url = 'https://api.macvendors.com/'+mac
    try:
        response = requests.get(url, timeout = 5)
        if response.status_code == 200:
            return response.content.decode()
        else:
            return "None"
    except requests.exceptions.ReadTimeout:
        return "None"

def create_packet(dst_ip):
    arp = scapy.ARP(pdst = dst_ip)
    ether = scapy.Ether(dst = "ff:ff:ff:ff:ff:ff")
    packet = ether / arp
    return packet

def process_packet(packet, iface):
    answered =  scapy.srp(packet, verbose = False, retry = 5, timeout = 1, iface = iface)[0]
    print(f"IP\t\tMAC\t\t\tVendor\n{'-'*80}")
    for answer in answered:
        print(f"{answer[1].psrc}\t{answer[1].hwsrc}\t{get_mac_vendor(answer[1].hwsrc)}")

if __name__ == '__main__':
    args = get_parser()
    iface = str(args.iface[0])
    ipaddr = str(args.ipaddr[0])
    if iface not in scapy.get_if_list():
        print(f"No interface named {iface} found!")
        exit()
    packet = create_packet(ipaddr)
    process_packet(packet, iface)
