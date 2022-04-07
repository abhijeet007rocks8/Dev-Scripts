
# Network Discovery

A python powered tool for scanning your local network. This tool shows you the devices currently connected in your network.

## Getting Started

- Clone the repository
```
git clone https://github.com/abhijeet007rocks8/Dev-Scripts.git
```
- Move to the executable folder
```
cd Dev-Scripts/Python/network-discovery
```

## Deployment

### Download and install python
#### Debian linux
```
sudo apt update
sudo apt install python3 
sudo apt install python3-pip
```
#### Fedora linux
```
sudo yum update
sudo yum install python3 
sudo yum install python3-pip
```
#### Windows

Download from https://www.python.org/downloads/

### Installing the dependencies

- Make sure you are in the `Dev-Scripts/Python/network-discovery` folder
- Install the requirements
```
pip install -r requirements.txt
```

After this, you are good to go!


## Launching
The command is as simple as it gets. Simply type,
```
python3 net.py --help
```

## Usage Demo
- A command demonstrating the scan of your local network
- Interface name - wlan0, IP Address - 192.168.1.0, Network mask - 24 (CIDR notation)

```
python3 local_discover.py -i wlan0 -a 192.168.1.0/24
```

## Tech Stack

- Python3

## Author 

Rajdip Bhattacharya
