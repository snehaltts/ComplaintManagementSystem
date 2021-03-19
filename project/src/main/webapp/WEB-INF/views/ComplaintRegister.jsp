<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Complaint</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        
    </head>
    <body>
     <div class="container">
  <h1>Complaint Form:</h1>
  <div class="card">
   <div class="card-body">
   
    <form method="post" action="complaintregister">
            <center>
            <table width="50%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Provide your Queries</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Complaint Id</td>
                        <td><input type="text" name="comid" value="" /></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td><input type="text" name="complaintDescription" value="" /></td>
                    </tr>
                    <tr>
                        <td>Complaint Incharge</td>
                        <td><input type="text" name="complaintIncharge" value="" /></td>
                    </tr>
                    <tr>
                        <td>Subject</td>
                        <td><input type="text" name="complaintSubject" value="" /></td>
                    </tr>
                    <tr>
                        <td>Type</td>
                        <td><input type="text" name="complaintType" value="" /></td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td><input type="text" name="requestStatus" value="" /></td>
                    </tr>
                    <tr>
                    <td>Date</td>
                    <td><input type="date" name="date" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" class = 'btn btn-primary'/></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
     </div>
  </div>
</div>
</body>
</html>