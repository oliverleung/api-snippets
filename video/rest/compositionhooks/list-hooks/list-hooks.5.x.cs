// Install the C# / .NET helper library from twilio.com/docs/csharp/install

using System;
using Twilio;
using Twilio.Converters;
using Twilio.Rest.Video.V1;
using static Twilio.Rest.Video.V1.CompositionHookResource;

class Program
{
    static void Main(string[] args)
    {
        // Find your API Key SID and Secret at twilio.com/console
        const string apiKeySid = "SKXXXX";
        const string apiKeySecret = "your_api_key_secret";

        TwilioClient.Init(apiKeySid, apiKeySecret);

        var hooks = CompositionHookResource.Read(
            enabled: true
        );

        foreach(var hook in hooks)
        {
           Console.WriteLine(hook.Sid);
        }

    }
}
