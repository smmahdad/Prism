from geopy.geocoders import Nominatim
from geopy.distance import vincenty
import fileinput
import sys
from time import sleep

#Allows us to find all distances between the cities in order of the list
def findCitiesAndDistances(listOfCities):
	geolocator = Nominatim()

	distanceBetweenCities = []

	dictionaryOfLocations = {}

	#Geopy only allows 1 request per second, so I make the system sleep for
	#2 seconds to ensure it doesn't time out
	sleep(1)

	#We find the location of the given city
	nextLocation = geolocator.geocode(listOfCities[0])
	#Take the coordinates from the given city
	nextCoord = (nextLocation.latitude, nextLocation.longitude)
	#Cache the coordinates so if we ever need it again we don't have to
	#request it from Geopy
	dictionaryOfLocations[listOfCities[0]] = nextCoord

	#We go through all the pairs of cities, so if we have 3 cities,
	#we only have 2 pairs. Hence we subtract 1 from the length.
	for index in range(len(listOfCities) - 1):
		locCoord = nextCoord

		#We check to see if we have the city in our cache
		if listOfCities[index + 1] in dictionaryOfLocations:
			#if so we use our cache
			nextCoord = dictionaryOfLocations[listOfCities[index + 1]]
		else:
			#Sleep again to ensure we don't timeout from our request cap
			sleep(1)
			#Find our location within Geopy
			nextLocation = geolocator.geocode(listOfCities[index + 1], timeout=None)
			nextCoord = (nextLocation.latitude, nextLocation.longitude)

			#Add the location to the cache
			dictionaryOfLocations[listOfCities[index + 1]] = nextCoord

		#We compute the distance via vincenty of coordinates into miles
		#Bonus point could have been solved by having a simple if statement
		#with a boolean flag to switch from miles to km
		distance = vincenty(locCoord, nextCoord).miles
		distanceBetweenCities.append(distance)

	printItinerary(listOfCities, distanceBetweenCities)

#Printing of all the distances between cities
def printItinerary(listOfCities, distanceBetweenCities):
	print("Success! Your vacation itinerary is:\n")
	totalDistance = 0

	#We will iterate through all the distances we have in our list
	#and print them out
	for index in range(len(distanceBetweenCities)):
		totalDistance += distanceBetweenCities[index]
		outputString = "\t {0} -> {1}: {2:,.2f} miles".format(listOfCities[index], \
								listOfCities[index + 1], distanceBetweenCities[index])
		print(outputString)
	print("\nTotal distance covered in your trip: {0:,.2f} miles".format(totalDistance))
	
#Initialization of our script from the file given
listOfCities = []
for line in fileinput.input():
	listOfCities.append(line.rstrip("\n").replace("\"", ""))

#Start of our program
findCitiesAndDistances(listOfCities)




