# Download the Python helper library from twilio.com/docs/python/install
import json
from urllib.request import urlopen

from twilio.rest import Client

# Your Account Sid and Auth Token from twilio.com/console
api_key_sid = "SKXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
api_key_secret = "your_api_key_secret"
client = Client(api_key_sid, api_key_secret)

room_sid = "RMXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
recording_sid = "RTXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
uri = "https://video.twilio.com/v1/" \
      "Rooms/{}/" \
      "Recordings/{}/" \
      "Media".format(room_sid, recording_sid)
response = client.request("GET", uri)
media_location = json.loads(response.text).get("redirect_to")

media_content = urlopen(media_location).read()
print(media_content)
