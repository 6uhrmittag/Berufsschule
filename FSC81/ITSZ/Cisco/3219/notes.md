

Step 3: Configure basic settings for each router and switch.
a. Disable DNS lookup.
	conf t
	no ip domain-lookup
b. Configure device names as shown in the topology.
	hostname
c. Configure password encryption.
	service password-encryption
d. Assign class as the privileged EXEC password.
	enable secret 	class
e. Assign cisco as the console and vty passwords.
	conf-t
	line vty 0 4
	login
	passwort cisco
	
	line con 0
	login passwort cisco
f. Configure a MOTD banner to warn users that unauthorized access is prohibited.
	banner motd $text$
g. Configure logging synchronous for the console line.
	logging synchronous
	
h. Configure the IP addresses listed in the Addressing Table for all interfaces.
interface x
ip address ip subnet
no shut

i. Configure a description for each interface with an IP address.
desc TEXT
j. Configure the clock rate, if applicable, to the DCE serial interface.
conf interface
clock rate ? <- view avalilable clockrate
clock rate x
k. Copy the running-configuration to the startup-configuration.
copy running-config startup-config
