
<div style="background-color:#2c3e50; padding:20px; border-radius:8px; text-align:center;">
  <h1 style="color:#ffffff; font-weight:bold; text-decoration:underline; margin:0;">
    🚀 Kafka Project — Microservices Architecture
  </h1>
  <p style="margin-top:15px;">
    <img src="https://img.shields.io/badge/Java-17-blue" />
    <img src="https://img.shields.io/badge/SpringBoot-3-green" />
    <img src="https://img.shields.io/badge/Kafka-EventStreaming-orange" />
  </p>
</div>

---

## 📖 Project Description

<p>
This project demonstrates how <b>Apache Kafka</b> integrates with <b>Spring Boot microservices</b> to enable real-time event streaming.  
It elaborates on how different services interact via Kafka topics:
</p>

<ul>
  <li>📦 <b>Delivery Service</b> — Produces delivery location updates in real-time.</li>
  <li>🔔 <b>Notification Service</b> — Consumes location updates and automatically pushes notifications.</li>
  <li>👤 <b>User Service</b> — Provides APIs for end users to query current delivery location.</li>
  <li>⚙️ <b>Common Service</b> — Hosts shared Kafka topics used by all microservices.</li>
</ul>

---

## 🏗️ Microservices Overview

<table>
  <tr>
    <th>Service</th>
    <th>Role</th>
    <th>Kafka Interaction</th>
  </tr>
  <tr>
    <td>Delivery Service</td>
    <td>Updates delivery location</td>
    <td>Producer → <code>delivery-topic</code></td>
  </tr>
  <tr>
    <td>Notification Service</td>
    <td>Pushes notifications</td>
    <td>Consumer → <code>delivery-status</code></td>
  </tr>
  <tr>
    <td>User Service</td>
    <td>Provides real-time location to end users</td>
    <td>Consumer → <code>user-location</code></td>
  </tr>
  <tr>
    <td>Common Service</td>
    <td>Shared topics for all services</td>
    <td>Producer + Consumer</td>
  </tr>
</table>

---
## 🔗 API Endpoints (Postman Examples)

<p>
Below are the key APIs exposed by the microservices. This section is separated and styled with HTML for clarity. You can test them using <b>Postman</b> or any REST client.
</p>

<hr/>

<h3>📍 Update Delivery Location</h3>
<p><b>Method:</b> POST</p>
<p><b>Endpoint:</b> <code>http://localhost:8083/delivery/updateLocation</code></p>
<p><b>Description:</b> Updates delivery boy’s current location and produces a Kafka message.</p>

<pre>
POST 'http://localhost:8083/delivery/updateLocation?deliveryBoyId=D101&location=45%2C67'
Body: (empty)
</pre>

<hr/>

<h3>📍 Get Delivery Locations</h3>
<p><b>Method:</b> GET</p>
<p><b>Endpoint:</b> <code>http://localhost:8085/user/getDeliveryLocations</code></p>
<p><b>Description:</b> Fetches current delivery locations for end users by consuming Kafka messages.</p>

<pre>
GET 'http://localhost:8085/user/getDeliveryLocations'
</pre>

<hr/>
---

## ⚙️ Setup Instructions

```bash
# Clone the repository
git clone https://github.com/your-repo/kafka-microservice.git

# Navigate into project
cd kafka-microservice

# Run with Maven
mvn spring-boot:run

---

## 🏁 How to Start


Follow these steps to run Kafka locally on Windows after downloading and unzipping the Kafka tar file into <code>C:\kafka</code>.  
Open PowerShell and execute the following commands in sequence:


```powershell
# 1. Start Zookeeper
java -Xmx512M -Xms256M -cp ".\libs\*;.\config" org.apache.zookeeper.server.quorum.QuorumPeerMain .\config\zookeeper.properties

# 2. Start Kafka Broker (new terminal)
java -Xmx512M -Xms256M -cp ".\libs\*;.\config" kafka.Kafka .\config\server.properties

# 3. Create a Topic (new terminal)
.\bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

# 4. Start Producer
.\bin\windows\kafka-console-producer.bat --topic test-topic --bootstrap-server localhost:9092

# 5. Start Consumer
.\bin\windows\kafka-console-consumer.bat --topic test-topic --bootstrap-server localhost:9092 --from-beginning

```


<h2 style="background-color:#2c3e50; color:#ffffff; font-weight:bold; text-align:center; padding:10px; border-radius:5px; text-decoration:underline;">
🙏 Thank You
</h2>

<p style="background-color:#2c3e50; color:#ffffff; font-weight:bold; text-align:center; padding:15px; border-radius:5px;">
Thank you for reviewing this project.  
Your support, feedback, and contributions are greatly appreciated.  
Keep innovating with <span style="color:#ffffff; font-weight:bold;">Java</span>, 
<span style="color:#ffffff; font-weight:bold;">Spring Boot</span>, and 
<span style="color:#ffffff; font-weight:bold;">Kafka</span> to build secure, modern applications.
</p>

---

