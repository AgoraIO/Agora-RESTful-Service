# Agora Cloud Recording Postman Collection

Agora offers a Postman collection that contains sample RESTful API requests for cloud recording. You can use the sample requests to:

- Record a live broadcast in composite recording mode
- Configure the video layout and update the layout during recording
- Store the recorded files in the third-party cloud storage that you specify.

To know more about what you can do with Cloud Recording RESTful APIs, refer to [Agora Cloud Recording RESTful API](https://docs.agora.io/en/cloud-recording/cloud_recording_api_rest?platform=All%20Platforms).

# Prerequisites

Complete the following tasks before you start trying the Cloud Recording RESTful APIs. You can find more details in the [Cloud Recording RESTful API Quickstart](https://docs.agora.io/en/cloud-recording/cloud_recording_rest?platform=All%20Platforms).

- Deploy a third-party cloud storage.

- Enable cloud recording.

- An app that integrates the [Agora RTC SDK](https://docs.agora.io/en/Agora%20Platform/terms?platform=All%20Platforms#rtc-sdk).
- [Install Postman](https://www.getpostman.com/downloads/).

## Import Postman collection

- Clone the repo.

- Open `Cloud_Recording.postman_environment.json` and enter values for the variables. You can find more details about these variables in [Agora Cloud Recording RESTful API](https://docs.agora.io/en/cloud-recording/cloud_recording_api_rest?platform=All%20Platforms).

  - `APPID`: The [App ID](https://docs.agora.io/en/Agora%20Platform/terms?platform=All%20Platforms#a-nameappidaapp-id) used in the channel that you want to record.
  - `CustomerID`: Find your Customer ID and Customer Certificate on the RESTful API page in [Console](https://console.agora.io/). See [RESTful API authentication](https://docs.agora.io/en/faq/restful_authentication) for details.
  - `CustomerCertificate`: Find your Customer ID and Customer Certificate on the RESTful API page in [Console](https://console.agora.io/). See [RESTful API authentication](https://docs.agora.io/en/faq/restful_authentication) for details.
  - `resourceId`: You do not need to enter any value for this variable. This variable is automatically populated with the response of the `acquire` method.
  - `AccessChannel`: Name of the channel that you want to record.
  - `RecordingUID`: String that contains the UID of the recording client, for example `"527841"`. The UID needs to meet the following requirements:
    - It is a 32-bit unsigned integer within the range between 1 and (2<sup>32</sup>-1).
    - It is unique and does not clash with any existing UID in the channel.
    - It should not be a string. Ensure that all UIDs in the channel are integers.
  - `Bucket`: The bucket of the third-party cloud storage.
  - `AccessKey`: The access key of the third-party cloud storage.
  - `SecretKey`: The secret key of the third-party cloud storage.
  - `sid`: You do not need to enter any value for this variable. This variable is automatically populated with the response of the `start` method.
- Open Postman and import `Cloud_Recording.postman_collection.json` and `Cloud_Recording.postman_environment.json`.
- Make sure you select the `Agora-Development` environment.
![img](./pics/select_env.png)




## Acquire the resource ID

After you set up the environment in Postman and get your live stream running, call the `acquire` method to get your resource ID. To do so, double-click **acquire** to open the request in a new tab, and click **Send** to send the request. You can find the response of the request in the **Response** section.

![img](./pics/acquire_response.png)

## Start and stop recording

Now that you have your resource ID, you can call the `start` method to begin recording and the `stop` method to end recording.

> The resource ID is valid for five minutes, so you need to start recording with this resource ID within five minutes.

You can also call the `query` and the `updateLayout` methods during a recording session. The `query` method allows you to know the status of the recording, and the `updateLayout` method allows you to change the layout configuration of the recording in composite recording mode. 



## Play recorded files online

If the media streams are successfully recorded, you can find recorded files in the specified third-party cloud storage and play them online. Refer to [Play Recorded Files Online](https://docs.agora.io/en/cloud-recording/cloud_recording_onlineplay?platform=All%20Platforms) for more information.

