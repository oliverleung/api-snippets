# Download the helper library from https://www.twilio.com/docs/ruby/install
require 'rubygems'
require 'twilio-ruby'

# Find your credentials at twilio.com/console
api_key_sid = 'SKXXXX'
api_key_secret = 'your_api_key_secret'

@client = Twilio::REST::Client.new(api_key_sid, api_key_secret)

compositionHook = @client.video.compositionHooks.create(
  friendlyName: 'MyHookWithComplexVideoLayout',
  audio_sources: ['listener-audio','presenter-audio'],
  video_layout: {
    main: {
      z_pos: 1,
      video_sources: ['screen']
    },
    pip: {
      z_pos: 2,
      x_pos: 1000,
      y_pos: 30,
      width: 240,
      height: 180,
      video_sources: ['presenter-cam']
    }
  },
  status_callback: 'http://my.server.org/callbacks',
  resolution: '1280x720',
  format: 'mp4'
)

puts compositionHook.sid
