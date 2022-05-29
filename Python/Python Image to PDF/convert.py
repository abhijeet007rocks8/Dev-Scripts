from PIL import Image


def main():
    # Load all the images in dedicated variable
    image1 = Image.open('Flower Image 1.jpg')
    image2 = Image.open('Flower Image 2.jpg')
    image3 = Image.open('Flower Image 3.jpg')
    image4 = Image.open('Flower Image 4.jpg')
    image5 = Image.open('Flower Image 5.jpg')

    # Convert all the images to RGB
    image1.convert('RGB')
    image2.convert('RGB')
    image3.convert('RGB')
    image4.convert('RGB')
    image5.convert('RGB')

    # List of image variables (without the first image)
    # Maintain image order if necessary
    # I'm not including my desired order's first image in the list
    # My desired first image is "image1"
    imageList = [image2, image3, image4, image5]

    # Creation of PDF
    fileName = 'Flowers.pdf'  # Filename of PDF
    # Now is the perfect time to use my first image
    # The PDF will organize Flower images in below order
    # image1, image2, image3, image4, image5
    # image1 is showing first because of using this for the saving process
    image1.save(fileName, save_all=True, append_images=imageList)

    # End
    print('Done')


if __name__ == '__main__':
    main()
