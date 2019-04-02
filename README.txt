Requirements
Java 8
MS SQL Server

Setup
Run resources/db/createdb.sql from inside SQL Server to create the user login and Database.
(If this isn't run then flyway will not be able to run db/migration/V1__2.testdata.sql to populate the tables)

The images are in resources/static/images.

Below is a brief description of each of the components I've added:
ChildController: API endpoints for Child
PictureController: API endpoints for Picture
ResourceNotFoundException: This exception is returned by the API if a Resource cannot be found
Child & Picture: These are the Domain Model classes.
ChildRepository & PictureRepository: These classes provide basic methods to manipulate the data via the Models above.
APIKeyAuthFilter & APISecurityConfig: These classes setup the the clientid for basic security.


