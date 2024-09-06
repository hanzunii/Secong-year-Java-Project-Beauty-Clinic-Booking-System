<%@ page import="java.util.List" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="com.example.DoctorDetails" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Details Gallery</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        .header {
            padding: 20px;
            text-align: center;
            background: #333;
            color: #fff;
        }
        .grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: 20px;
            padding: 20px;
        }
        .image-item {
            background: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            overflow: hidden;
            text-align: center;
            transition: transform 0.3s ease;
            text-decoration: none;
            color: inherit;
        }
        .image-item:hover {
            transform: scale(1.05);
        }
        .image-item img {
            width: 100%;
            height: auto;
            display: block;
        }
        .caption {
            padding: 10px;
            background: #f9f9f9;
            border-top: 1px solid #ddd;
        }
        .caption p {
            margin: 0;
            color: #333;
        }
        .button-container {
            text-align: center;
        }
        .view-button {
            background-color: #28a745;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            margin: 10px;
            display: inline-block;
            text-decoration: none;
        }
        .view-button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Information of Doctors</h1>
        <p>Every Monday to Saturday, the doctors take their regular time for each day.</p><br>
        <p>Select the doctor that will suit or be convenient for you.</p>
    </div>
    <div class="container">
        <div class="grid">
            <%
                List<DoctorDetails> doctorList = (List<DoctorDetails>) session.getAttribute("doctorList");
                if (doctorList != null) {
                    for (DoctorDetails doctorDetails : doctorList) {
                        String imageFileName = doctorDetails.getImageFileName();
                        String doctorName = doctorDetails.getDoctorName();
                        String bachelor = doctorDetails.getBachelor();
                        String arrtime = doctorDetails.getArrtime();
                        String deptime = doctorDetails.getDeptime();
                        
                        // Encode the doctor name for URL
                        String encodedDoctorName = URLEncoder.encode(doctorName, "UTF-8");
                        
                     // Define a URL to the information page
                        String infoPageUrl = request.getContextPath() + "/Information.html";

                        
                        out.print("<div class='image-item'>");
                        out.print("<img src='uploads/" + imageFileName + "' alt='Doctor Image'>");
                        out.print("<div class='caption'>");
                        out.print("<p><strong>Doctor Name:</strong> " + doctorName + "</p>");
                        out.print("<p><strong>Bachelor:</strong> " + bachelor + "</p>");
                        out.print("<p><strong>Arriving Time:</strong> " + arrtime + "</p>");
                        out.print("<p><strong>Depart Time:</strong> " + deptime + "</p>");
                        out.print("<div class='button-container'>");
                        out.print("<a href='" + infoPageUrl + "' class='view-button'>Fill Information</a>");
                        out.print("</div>");
                        out.print("</div>");
                        out.print("</div>");
                    }
                } else {
                    out.print("<p>No doctor details found.</p>");
                }
            %>
        </div>
    </div>
</body>
</html>
