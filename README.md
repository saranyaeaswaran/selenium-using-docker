# selenium-using-docker
Basic setup of running selenium java test cases using Docker

## Docker installation instructions :
* Get docker for windows downloadable from https://hub.docker.com/editions/community/docker-ce-desktop-windows and install
* Docker required windown10 professional or enterprise edition to work
* To check if docker is successfully installed in the machine, check the version, no need to add to 'path' explicitly
		C:\Users\username>docker --version
		Docker version 18.09.2, build 6247962
* Check in Task Manager > Performance Tab > Virtualization value should be enabled, If its disabled docker client wont start. 
	○ To enable this enter into BIOS>F10>Advanced>Device Configurations>VTx>Enabled and Save the changes
	○ To enable this run cmd as administrator and execute this command 'dism.exe /Online /Enable-Feature:Microsoft-Hyper-V /All'
	○ To enable hypervisor > bcdedit /set hypervisorlaunchtype auto
	○ Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V-Hypervisor
* To check the current containers running in docker, the command is > docker ps
* DockerHub - repository for docker images - https://hub.docker.com/
* To see the images downloaded in the system > docker images

### Using chrome browser to run selenium tests in Docker:
* All selenium images provided by Seleniumhq - https://github.com/SeleniumHQ/docker-selenium
* Go to Dockerhub and search for selenium - all available selenium images will be listed, search for the latest version
* Dowload latest image 'selenium/standalone-chrome' from Dockerhub using cmd command > **docker pull selenium/standalone-chrome:latest**
* To view the docker images available in your system > docker images
* Now to deploy this image on the container > **docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:latest**
		○ docker run > to start a container
		○ -d > to run in the background
		○ -p > to get from port
		○ 4444:4444> from port 4444 of local OS to port 4444 of the container OS port
		○ -v /dev/shm:/dev/shm > to share the local host memory > this is a workground for chromer crashing in the container
		○ selenium/standalone-chrome:latest > the downloaded image
* 'docker ps' show us the container started with the given image
  
  *selenium code:*
  ```java
  	public static void main(String[] args) throws MalformedURLException {
		//For running the tests remotely we have to use Remote Web driver which takes URL and Capabilities as arguments. URL should be which URL the remote driver should listen to. The browser will not open in this case but will be running in the remotedriver.		
		URL url;
		url = new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		RemoteWebDriver remoteDriver = new RemoteWebDriver(url, capabilities);
		remoteDriver.get("https://www.google.com");
		System.out.println(remoteDriver.getTitle());
  }
  ``` 
 
### Using firefox browser to run selenium tests in Docker:  
* Get the latest image name for the seleniumhq github page : selenium/standalone-firefox
* Download the image from docker hub > docker pull selenium/standalone-firefox:latest
* Deploy this image into container using the command > docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-firefox:latest
* But if the 4444 port is already engaged by the selenium image then we will get an error, so to stop the chrome container use the command > docker stop <CONTAINER ID>
* Now run the firefox deploy image command again
* Selenium code:*
  ```java
		public static void main(String[] args) throws MalformedURLException {
			//For running the tests remotely we have to use Remote Web driver which takes URL and Capabilities as arguments. URL should be which URL the remote driver should listen to. The browser will not open in this case but will be running in the remotedriver.		
			URL url;
			url = new URL("http://localhost:4444/wd/hub");
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
			RemoteWebDriver remoteDriver = new RemoteWebDriver(url, capabilities);
			remoteDriver.get("https://www.google.com");
			System.out.println(remoteDriver.getTitle());
  }
  ```
  
  
  


