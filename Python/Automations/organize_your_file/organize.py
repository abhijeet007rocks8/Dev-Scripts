import os
import shutil

current_dir = os.path.dirname(os.path.realpath(__file__))
print(current_dir)
print("Welcome in organize.py script - happy clean folder")
for filename in os.listdir(current_dir):
    # organize Imags into image folder
    if filename.endswith((".png", ".jpg", ".gif", "jpeg")):
        if not os.path.exists('Imags'):
            os.mkdir('Imags')
        shutil.copy(filename, "Imags")
        os.remove(filename)
        print("Done imags")

      # organize code files into code folder
    if filename.endswith((".css", ".py", ".html", 'bash', ".js")):
        if not os.path.exists('Codes'):
            os.mkdir('Codes')
        shutil.copy(filename, "Codes")
        os.remove(filename)
        print("Done cods")

   # organize video files into Video folder
    if filename.endswith((".mp4", ".webm")):
        if not os.path.exists('videos'):
            os.mkdir('videos')
        shutil.copy(filename, "videos")
        os.remove(filename)
        print("Done")

   # organize DOcs files into Document folder
    if filename.endswith((".pdf", ".word")):
        if not os.path.exists('Docs'):
            os.mkdir('Docs')
        shutil.copy(filename, "Docs")
        os.remove(filename)
        print("Done")

    # organize Archive files into Archives folder
    if filename.endswith((".zip", ".rar","tar")):
        if not os.path.exists('Archives'):
            os.mkdir('Archives')
        shutil.copy(filename, "Archives")
        os.remove(filename)
        print("Done")    

        # organize app files into apps folder
    if filename.endswith((".exe", ".dmg")):
        if not os.path.exists('Apps'):
            os.mkdir('Apps')
        shutil.copy(filename, "Apps")
        os.remove(filename)
        print("Done")

print("Done organizing this folder")
