# LignesDeTransport-API : On Your Way

![](./logo.png)

Authors:
 - Anna Christina Kolandjian
 - Clarisse Pouillery
 
 # 🎯 Goal
Realization of an API with Nest JS and an Android application allowing to visualize OpenData

# 📝 Description 
We chosed to process public transport lines in the Ile-de-France region.
This application will give your the name and the number lines, the transport mode and other details such as the accessibility and the status.

CleverCloud application link: [link](https://lignes-ack-cpy.cleverapps.io/lignes/).

Data link: [link](https://data.opendatasoft.com/explore/dataset/referentiel-des-lignes%40stif/api/?disjunctive.transportmode&disjunctive.transportsubmode&disjunctive.operatorname&disjunctive.networkname&sort=transportmode).

# Web Development 
 1. OpenData data:
   - JSON format
   - With a field corresponding to the url of an image or a type allowing different images to be displayed in a list.
   - Directly stored in the API code via a json file and used when starting the API.
 
 2. Expose URLs to make queries to :
   - Retrieve a summary of all data (i.e. only the most important information for display in a list + favorite or not). 
   - Retrieve the details of a data (for display in the details screen). 
   - Bookmark or not. 

 3. Deployed on CleverCloud

## Web Bonus (Optional)
 - Instead of storing data in a JSON file, make a query at API startup to retrieve the data.
 - Add a route to create new data
 
# Android Development 
 1. Retrieving data from the api and displaying it in a list and a screen with details
 2. Possibility to bookmark certain elements
 3. Application consisting of at least : 
   - 2 Fragment (the list + the screen with the information)
   - 2 Activity
 4. A Toolbar will be present and will allow to refresh the data retrieved and displayed.

## Android Bonus (Optional)
 - Improving the user experience : Implementation of a search/filter system on the list displayed
 - Technical enrichments :
   - Implementation of a local database to display the item list in offline mode
   - Using LiveData or Observable to recover data from the database

# Our last words
We enjoyed working on this project, even if we had some difficulties with the deployment of CleverCloud, Android Studio and its famous emulator. 
We tried to select the data that we thought was important on the public transport lines in the Ile-de-France region, such as accessibility or the transport mode for example.
And here is the result!  We have attached 3 photos that represent the three views available in our Android application.
We hope you'll enjoy this project and have a good discovery! :)
