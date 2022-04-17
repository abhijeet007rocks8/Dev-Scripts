from optparse import OptionParser
from sys import exit
import numpy as np
import imutils
import cv2


usage = """
<Script> [Options]

[Options]:
    -h, --help      Shows this help message and exit.
    -t, --template  Choose template image. (default: Template.jpg)
    -i, --image     Choose image to detect logo inside.

"""

# Load args.
parser = OptionParser()
parser.add_option("-t", "--template", dest="template", default="Template.jpg",
                  help="Choose template image.")
parser.add_option("-i", "--image", dest="image",
                  help="Choose image to detect logo inside.")

if __name__ == "__main__":
    (options, args) = parser.parse_args()
    template = options.template
    image = options.image
    
    # Validate inputs.
    if not bool(image):
        print(usage)
        exit()

    # Load Images and convert to gray scale.
    template = cv2.imread(template)
    image = cv2.imread(image)
    templateGray = cv2.cvtColor(template, cv2.COLOR_BGR2GRAY)
    imageGray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    
    # Generate a linespace scale and loop through each image scale.
    max_corr = None
    for scale in np.linspace(0.1, 1.0, 25)[::-1]:
        resized_image = imutils.resize(imageGray, width= int(imageGray.shape[1]*scale) )
        
        # If the resize image dimensions is smaller than the \
        # template image dimensions then break to avoid \
        # Assertion Error. (smaller scales will give same result.)
        if resized_image.shape[0] < templateGray.shape[0] or resized_image.shape[1] < templateGray.shape[1]:
            break
        
        # Commence matching templates
        match_res = cv2.matchTemplate(templateGray, resized_image, cv2.TM_CCOEFF_NORMED)
        (_, MaxVal, _, MaxLoc) = cv2.minMaxLoc(match_res)
        
        # update max_corr if a bigger normalized correlation \
        # coefficient is found.
        if max_corr is None or MaxVal > max_corr[0]:
            resize_ratio = imageGray.shape[1] / float(resized_image.shape[1])
            max_corr = (MaxVal, MaxLoc, resize_ratio)

    # Extract correlation location and assign rectangle end coordinates.
    # No need for MaxVal now.
    maxLoc, ratio = max_corr[1], max_corr[2]
    StartX, StartY = int( maxLoc[0]*ratio ) , int( maxLoc[1]*ratio )
    EndX = int( (maxLoc[0] + template.shape[1]) * ratio )
    EndY = int( (maxLoc[1] + template.shape[0]) * ratio )

    # Draw the rectangle, save & display the image for 5 seconds.
    final = cv2.rectangle(image, (StartX, StartY), (EndX, EndY), (0, 255, 0), 3)
    cv2.imshow("Output.png", final)
    cv2.imwrite("Output.png", final)
    cv2.waitKey(5000) # Image will be displayed for 5 seconds. (5000 ms)
