#!/usr/bin/env python3
"""
CASE
Your company is in the process of updating its website, and they've hired a design contractor to create some new icon graphics for the site. But the contractor has delivered the final designs in the wrong format -- rotated 90° and too large. Oof! You're not able to get in contact with the designers and your own deadline is approaching fast. You'll need to use Python to get these images ready for launch.
"""
"""
DOWNLOAD EXAMPLE FILE
curl -c ./cookie -s -L "https://drive.google.com/uc?export=download&id=$11hg55-dKdHN63yJP20dMLAgPJ5oiTOHF" > /dev/null | curl -Lb ./cookie "https://drive.google.com/uc?export=download&confirm=`awk '/download/ {print $NF}' ./cookie`&id=11hg55-dKdHN63yJP20dMLAgPJ5oiTOHF" -o images.zip && sudo rm -rf cookie
"""

import os, sys
from PIL import Image

user = os.getenv('USER')
images_dir = '/home/{}/images/'.format(user)

for img in os.listdir(images_dir):
  if not img.startswith('.'):
    image_path=images_dir+img
    im=Image.open(image_path)
    new_path='/opt/icons/'+img.split('.')[0]
    im.rotate(-90).convert('RGB').resize((128,128)).save(new_path,'jpeg')
    im.close()
