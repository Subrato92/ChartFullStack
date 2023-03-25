This project has three folders 

	1. "fwfullstackrole_wellsfargo_codetest" - The test description folder
	2. "wellsfergo-be" : SpringBoot BackEnd Service
	3. "ChartFullStack-Fe" : React FrontEnd Service

BackEnd Service Description : 

	This service has two Apis - 
		1. POST /load/csv : Responsible for loading csv file
			curl --location --request POST 'http://localhost:8080/load/csv' \
			--form 'file=@"/D:/Projects/Wellsfargo/fwfullstackrole_wellsfargo_codetest/202303 SQSE India Code Test Data.csv"'
		2. GET /data/all : Responsible for fetching File Data
			curl --location --request GET 'http://localhost:8080/data/all?fileId=1'
		
	This service has integrated H2 In Memory dB for storing csv data.
	It will have two Tables - 
		1. FileDetails
		1. FileData
	
	Dependencies -
		1. JDK 11
		2. Maven 3.6.3
		
FrontEnd Service Description :

	1. Frontend Service is based on React.js
	2. I have used Chart.js for Data visualization
	3. Used BootStrap 5 for Styling
	
	Dependencies -
		1. npm 9.6.2
	
	NOTE : If the front end module not getting downloaded - 
	       use git link : https://github.com/Subrato92/ChartFullStack-Fe.git
	       to download the frontend part of the project.
	
Execution Steps : 

	1. First start the backend Service (wellsfergo-be) 
		mvn clean install spring-boot:run
	2. Build the React Project 
		npm install
	3. Start the front end service 
		npm start
		
	NOTE : For Avaoiding CORS follow the annuxure steps

Features Developed : 

	1. From front End user can upload multiple files
	2. User can select the uploaded filed from the drop down and can visualize the data in the chart.
	
Annexure : 

	A. For Evading CORS - 
		https://stackoverflow.com/questions/3102819/disable-same-origin-policy-in-chrome
