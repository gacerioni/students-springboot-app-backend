__author__ = "Gabs - SE"
__copyright__ = "N/A - Feel free to edit and use this at will"
__credits__ = ["Gabriel Cerioni"]
__license__ = "GPL"
__version__ = "0.1.0"
__maintainer__ = "Gabriel Cerioni"
__email__ = "gabriel.cerioni@harness.io"
__status__ = "It is what it is."


import logging
import requests
import json

# optional - logging.basicConfig(filename='cli.log', filemode='a', format='%(asctime)s - %(levelname)s - %(message)s', level=logging.INFO)
logging.basicConfig(format='%(asctime)s - %(levelname)s - %(message)s', level=logging.DEBUG)

api_to_post_data = "http://gabsdemostudents.harnesscse.com/api/v1/students"


with open('MOCK_STUDENTS.json') as f:
    data = json.load(f)

for entry in data:
    r = requests.post(api_to_post_data, json=entry)