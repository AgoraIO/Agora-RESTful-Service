{
	"info": {
		"_postman_id": "ca2fc58e-54f6-4c7a-bf80-90280bff7dc9",
		"name": "Cloud_Recording",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "acquire",
			"event": [
				{
					"listen": "test",
					"script": {
						"id": "4def61c6-2dfb-452c-8839-ea0a24f2f0b9",
						"exec": [
							"var jsonData = JSON.parse(responseBody);",
							"var resourceId = jsonData.resourceId;",
							"console.log(resourceId);",
							"postman.setEnvironmentVariable(\"resourceId\", resourceId);"
						],
						"type": "text/javascript"
					}
				},
				{
					"listen": "prerequest",
					"script": {
						"id": "ea0e7e80-3278-4d5c-a214-1a30b810c6e5",
						"exec": [
							""
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "{{CustomerCertificate}}",
							"type": "string"
						},
						{
							"key": "username",
							"value": "{{CustomerID}}",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"cname\": \"{{AccessChannel}}\",\n  \"uid\": \"{{RecordingUID}}\",\n  \"clientRequest\":{\n  }\n}"
				},
				"url": {
					"raw": "https://api.agora.io/v1/apps/{{APPID}}/cloud_recording/acquire",
					"protocol": "https",
					"host": [
						"api",
						"agora",
						"io"
					],
					"path": [
						"v1",
						"apps",
						"{{APPID}}",
						"cloud_recording",
						"acquire"
					]
				},
				"description": "The RESTful API requires basic HTTP authentication. You need to set the Authorization parameter in every HTTP request header. \n\n> Authorization header is not visible in Postman Web View, use **Run In Postman** button above to view full example snippet\n\nUse the Acquire endpoint to receive the reqwuired token (`resourceId`) needed for use with each of the other Agora.io Cloud Recording endpoints. \n\nIf this method call succeeds, you will receive a _resource ID_ (`resourceId`) from the HTTP response body. The _resource ID_ is valid for five minutes, so you need to start recording with this _resource ID_ within five minutes."
			},
			"response": []
		},
		{
			"name": "start",
			"event": [
				{
					"listen": "test",
					"script": {
						"id": "20a4d1e4-ef00-4b08-8273-682c89c4860b",
						"exec": [
							"var jsonData = JSON.parse(responseBody);",
							"var sid = jsonData.sid;",
							"console.log(sid);",
							"postman.setEnvironmentVariable(\"sid\", sid);"
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "{{CustomerCertificate}}",
							"type": "string"
						},
						{
							"key": "username",
							"value": "{{CustomerID}}",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"cname\":\"{{AccessChannel}}\",\n\t\"uid\":\"{{RecordingUID}}\",\n\t\"clientRequest\":{\n\t\t\"recordingConfig\":{\n\t\t\t\"maxIdleTime\":120,\n\t\t\t\"streamTypes\":2,\n\t\t\t\"audioProfile\":1,\n\t\t\t\"channelType\":1,\n\t\t\t\"videoStreamType\":0,\n\t\t\t\"transcodingConfig\":{\n\t\t\t\t\"width\":360,\n\t\t\t\t\"height\":640,\n\t\t\t\t\"fps\":24,\n\t\t\t\t\"bitrate\":800,\n\t\t\t\t\"mixedVideoLayout\":1,\n\t\t\t\t\"maxResolutionUid\":\"1\"\n\t\t\t\t}\n\t\t\t},\n\t\t\"storageConfig\":{\n\t\t\t\"vendor\":1,\n\t\t\t\"region\":8,\n\t\t\t\"bucket\":\"{{Bucket}}\",\n\t\t\t\"accessKey\":\"{{AccessKey}}\",\n\t\t\t\"secretKey\":\"{{SecretKey}}\"\n\t\t}\t\n\t}\n} \n"
				},
				"url": {
					"raw": "https://api.agora.io/v1/apps/{{APPID}}/cloud_recording/resourceid/{{resourceId}}/mode/mix/start",
					"protocol": "https",
					"host": [
						"api",
						"agora",
						"io"
					],
					"path": [
						"v1",
						"apps",
						"{{APPID}}",
						"cloud_recording",
						"resourceid",
						"{{resourceId}}",
						"mode",
						"mix",
						"start"
					]
				},
				"description": "Call the start method within five minutes after getting the _resource ID_ to join a channel and start the recording.\n\nIf this method call succeeds, you get a _recording ID_ (`sid`) from the HTTP response body.\n\n> Note: Agora Cloud Recording does not support string usernames (User Accounts). Ensure that every user in the channel has an integer UID. When you call the start method, ensure that the UID in the quotation marks is an integer UID, too.\n\n"
			},
			"response": []
		},
		{
			"name": "stop",
			"event": [
				{
					"listen": "test",
					"script": {
						"id": "34e06486-5aef-42f4-91ed-4150f98d9560",
						"exec": [
							"var jsonData = JSON.parse(responseBody);",
							"var serverResponse = jsonData.serverResponse",
							"console.log(serverResponse);",
							"postman.setEnvironmentVariable(\"uploadingStatus\", serverResponse.uploadingStatus);"
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "{{CustomerCertificate}}",
							"type": "string"
						},
						{
							"key": "username",
							"value": "{{CustomerID}}",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [
					{
						"key": "",
						"value": "",
						"type": "text",
						"disabled": true
					},
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json;charset=utf-8",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n  \"cname\": \"channel\",\n  \"uid\": \"111\",\n  \"clientRequest\":{\n  }\n}"
				},
				"url": {
					"raw": "https://api.agora.io/v1/apps/{{APPID}}/cloud_recording/resourceid/{{resourceId}}/sid/{{sid}}/mode/mix/stop",
					"protocol": "https",
					"host": [
						"api",
						"agora",
						"io"
					],
					"path": [
						"v1",
						"apps",
						"{{APPID}}",
						"cloud_recording",
						"resourceid",
						"{{resourceId}}",
						"sid",
						"{{sid}}",
						"mode",
						"mix",
						"stop"
					]
				},
				"description": "Call the stop method to stop the recording.\n\nIf this method call succeeds, you get the M3U8 filename and the current uploading status from the HTTP response body.\n\n> Agora Cloud Recording automatically leaves the channel and stops recording when no user is in the channel for more than 30 seconds by default."
			},
			"response": []
		},
		{
			"name": "updateLayout",
			"event": [
				{
					"listen": "test",
					"script": {
						"id": "e55e1b30-631d-4d11-b70d-711948f077c5",
						"exec": [
							"var jsonData = JSON.parse(responseBody);",
							"var serverResponse = jsonData.serverResponse",
							"console.log(serverResponse);",
							"postman.setEnvironmentVariable(\"serverResponseFileList\", serverResponse.fileList);",
							"postman.setEnvironmentVariable(\"serverResponseStatus\", serverResponse.status);"
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "{{CustomerCertificate}}",
							"type": "string"
						},
						{
							"key": "username",
							"value": "{{CustomerID}}",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"type": "text",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"cname\":\"{{AccessChannel}}\",\n\t\"uid\":\"{{RecordingUID}}\",\n\t\"clientRequest\": {\n        \"mixedVideoLayout\": 3,\n        \"backgroundColor\": \"#FF0000\",\n        \"layoutConfig\": \n        [{\n             \"uid\": \"1\",\n             \"x_axis\": 0.1,\n             \"y_axis\": 0.1,\n             \"width\": 0.1,\n             \"height\": 0.1,\n             \"alpha\": 1.0,\n             \"render_mode\": 1\n         },\n         {\n             \"uid\": \"2\",\n             \"x_axis\": 0.2,\n             \"y_axis\": 0.2,\n             \"width\": 0.1,\n             \"height\": 0.1,\n             \"alpha\": 1.0,\n             \"render_mode\": 1\n        }]\n    }\n}"
				},
				"url": {
					"raw": "https://api.agora.io/v1/apps/{{APPID}}/cloud_recording/resourceid/{{resourceId}}/sid/{{sid}}/mode/mix/updateLayout",
					"protocol": "https",
					"host": [
						"api",
						"agora",
						"io"
					],
					"path": [
						"v1",
						"apps",
						"{{APPID}}",
						"cloud_recording",
						"resourceid",
						"{{resourceId}}",
						"sid",
						"{{sid}}",
						"mode",
						"mix",
						"updateLayout"
					]
				},
				"description": "During a recording, you can call this method to update the video mixing layout multiple times.\n\nThis method call overrides the existing layout configurations. \n\nFor example, if you set the backgroundColor parameter as \"#FF0000\" (red) when starting a recording and call this method to update the layout without setting the backgroundColor parameter, the background color changes back to black (the default value).\n\nThe following parameters are required in the URL.\n- `appid` _String_ The App ID used in the channel to be recorded.\n- `resourceid` _String_ The resource ID requested by the acquire method.\n- `sid` _String_ The recording ID created by the start method.\n- `mode` _String_ The recording mode. Supports individual mode (`individual`) and composite mode (`mix`).\n\nThe following parameters are required in the request `body`.\n- `cname` _String_ Name of the channel to be recorded.\n- `uid` _String_ The UID of the recording client. A 32-bit unsigned integer ranging from 1 to (232-1) that is unique in the channel, for example \"527841\". _Do not set it as \"0\"_\n- `clientRequest`  _JSON Object_ A specific client request. See full details below.\n\n`clientRequest` requires the following parameters:\n- `maxResolutionUid` (Optional) String. When the layoutType parameter is set as 2 (vertical layout), you can specify the UID of the large video window by this parameter.\n- `mixedVideoLayout` (Optional) Number. Sets the video mixing layout. 0, 1, and 2 are the predefined layouts. If you set this parameter as 3, you need to set the layout by the layoutConfig parameter.\n - `0` (Default) Floating layout: The first user in the channel occupies the full canvas. The other users occupy the small regions on top of the canvas, starting from the bottom left corner. The small regions are arranged in the order of the users joining the channel. This layout supports one full-size region and up to four rows of small regions on top with four regions per row, comprising 17 users.\n - `1` Best fit layout: This is a grid layout. The number of columns and rows and the grid size vary depending on the number of users in the channel. This layout supports up to 17 users.\n - `2` Vertical layout: One large region is displayed on the left edge of the canvas, and several smaller regions are displayed along the right edge of the canvas. The space on the right supports up to 2 columns of small regions with 8 regions per column. This layout supports up to 17 users.\n - `3` Customized layout: Set the layoutConfig parameter to customize the layout.\n- `backgroundColor` (Optional) String. The background color of the canvas (the display window or screen) in RGB hex value. The string starts with a \"#\". The default value is \"#000000\", the black color.\n- `layoutConfig` (Optional) JSONArray. An array of the configuration of each user's region. Supports 17 users at most. Each user's region configuration is a JSON object with the following parameters:\n - `uid` (Optional) String. The string contains the UID of the user displaying the video in the region. If this parameter is not specified, the configurations apply in the order of the users joining the channel.\n - `x_axis` (Mandatory) Float. Relative horizontal position of the top-left corner of the region. The value is between 0.0 (leftmost) and 1.0 (rightmost). x_axis can also be an integer 0 or 1.\n - `y_axis` (Mandatory) Float. Relative vertical position of the top-left corner of the region. The value is between 0.0 (top) and 1.0 (bottom). y_axis can also be an integer 0 or 1.\n - `width` (Mandatory) Float. Relative width of the region. The value is between 0.0 and 1.0. width can also be an integer 0 or 1.\n - `height` (Mandatory) Float. Relative height of the region. The value is between 0.0 and 1.0. height can also be an integer 0 or 1.\n - `alpha` (Optional) Float. The transparency of the image. The value is between 0.0 (transparent) and 1.0 (opaque). The default value is 1.0.\n - `render_mode` (Optional) Number. The video display mode:\n  - `0` (Default) Cropped mode: Uniformly scales the video until it fills the visible boundaries (cropped). One dimension of the video may have clipped contents.\n  - `1` Fit mode: Uniformly scales the video until one of its dimension fits the boundary (zoomed to fit). Areas that are not filled due to the disparity in the aspect ratio will be filled with black."
			},
			"response": []
		},
		{
			"name": "query",
			"event": [
				{
					"listen": "test",
					"script": {
						"id": "e55e1b30-631d-4d11-b70d-711948f077c5",
						"exec": [
							"var jsonData = JSON.parse(responseBody);",
							"var serverResponse = jsonData.serverResponse",
							"console.log(serverResponse);",
							"postman.setEnvironmentVariable(\"serverResponseFileList\", serverResponse.fileList);",
							"postman.setEnvironmentVariable(\"serverResponseStatus\", serverResponse.status);"
						],
						"type": "text/javascript"
					}
				}
			],
			"request": {
				"auth": {
					"type": "basic",
					"basic": [
						{
							"key": "password",
							"value": "{{CustomerCertificate}}",
							"type": "string"
						},
						{
							"key": "username",
							"value": "{{CustomerID}}",
							"type": "string"
						}
					]
				},
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "https://api.agora.io/v1/apps/{{APPID}}/cloud_recording/resourceid/{{resourceId}}/sid/{{sid}}/mode/mix/query",
					"protocol": "https",
					"host": [
						"api",
						"agora",
						"io"
					],
					"path": [
						"v1",
						"apps",
						"{{APPID}}",
						"cloud_recording",
						"resourceid",
						"{{resourceId}}",
						"sid",
						"{{sid}}",
						"mode",
						"mix",
						"query"
					]
				},
				"description": "During the recording, you can call the query method to check the recording status multiple times.\n\nIf this method call succeeds, you get the M3U8 filename and the current recording status from the HTTP response body."
			},
			"response": []
		}
	],
	"protocolProfileBehavior": {}
}