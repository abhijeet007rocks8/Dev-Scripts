import os
os.environ["TF_CPP_MIN_LOG_LEVEL"] = "3"

import torch
from torch import nn 
from torch.nn import functional as F
from torchvision import transforms


device = torch.device("cpu")

mean = 0.13066047430038452
std = 0.30810779333114624 
classes = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
OUTPUT_DIM = len(classes)

PROJECT_ROOT = os.path.dirname(os.path.abspath(__file__))

model_path = os.path.join(PROJECT_ROOT, "static", "mnist-classifier.pt")
 
class LeNet(nn.Module):
    def __init__(self, output_dim):
        super(LeNet, self).__init__()
        self.features = nn.Sequential(
            nn.Conv2d(in_channels=1, out_channels=6, kernel_size =5),
            nn.MaxPool2d(kernel_size=2),
            nn.ReLU(),
            nn.Conv2d(in_channels=6, out_channels=16, kernel_size =5),
            nn.MaxPool2d(kernel_size=2),
            nn.ReLU()
        )
        self.classifier = nn.Sequential(
            nn.Linear(16 * 4 * 4, 120),
            nn.ReLU(),
            nn.Linear(120, 84),
            nn.ReLU(),
            nn.Linear(84, output_dim)
        )
        
    def forward(self, x):
        x = self.features(x) # x = [batch size, 16, 4, 4]
        x = x.view(x.shape[0], -1) # x = [batch size, 16*4*4 = 256]
        x = self.classifier(x) # x = [batch size, output dim]
        return x

print(" *   LOADING MODEL")
model = LeNet(OUTPUT_DIM).to(device)
model.load_state_dict(torch.load(model_path, map_location=device))
print("\n *   DONE LOADING THE MODEL")

def predict_digit(model, device, image):
    model.eval()
    with torch.no_grad():
        image = image.view(-1, 1, 28, 28).to(device)
        predictions = F.softmax(model(image), dim=1)
        top_pred = int(predictions.argmax(1).item())
        predictions = predictions.squeeze().cpu().numpy()
        preds = [{"label": i, "class_name": classes[i], "probability":  float(prob) } for i, prob in enumerate(predictions)]
    
    return {
            "all":preds,
            "prediction": 
            {"label": top_pred, "class_name": classes[top_pred], "probability":  float(predictions[top_pred]) }
    }
    
def preprocess_img(img):
    """
    takes in a pillow image and pre process it
    """
    preproces_1 =  nn.Sequential(
    transforms.Resize([28,28]),
    transforms.Grayscale(1)
    )
    preprocess_2 =  nn.Sequential(
        transforms.Normalize(mean=[mean], std=[std], inplace=False)
    )
    img = preprocess_2(transforms.ToTensor()(preproces_1(img)))
    return img