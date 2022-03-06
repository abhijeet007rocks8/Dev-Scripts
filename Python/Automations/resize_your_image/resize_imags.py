from PIL import Image
import os

fit_size = int(input('Enter Size : '))
output_folder = input('Enter Output folder Name :')

if not os.path.exists(output_folder):
    os.mkdir(output_folder)


for filename in os.listdir('.'):
    if not filename.endswith((".png", ".jpg", "jpeg")):
        continue

    # open image-->get image size --->resize
    image = Image.open(filename)
    width , height = image.size
    if width > fit_size and height > fit_size:  # image shoud be grater than fit value
        if width > height:
            # fermula to cut image right way
            height = int((fit_size/width)*height)
            width = fit_size
        else:
            # fermula to cut image right way
            width = int((fit_size/height)*width)
            height = fit_size

        image = image.resize((width, height))
        print('Resizing : %s '%(filename))
    image = image.save(os.path.join(output_folder, filename))
    print('---------------------------------')
print("Done Resizeing all Images")
