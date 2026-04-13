<!DOCTYPE html>
<html>
<head>
    <title>Verify OTP</title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>
<div class="container">
<h2>Enter OTP to Delete File</h2>

<form action="verifyDeleteOTP" method="post">
    <input type="text" name="otp" placeholder="Enter OTP" required>
    <button type="submit">Verify & Delete</button>
</form>
</div>
</body>
</html>