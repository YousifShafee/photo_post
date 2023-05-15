# **Picture Publishing Service**

## **Overview**

Photo Post is a website where registered and logged in users can upload pictures for acceptance or rejection. An administrator will login and review all submissions. Accepted pictures will be assigned a URL which can be accessed by all users (without login). Rejected pictures have their pictures removed but the metadata remains.

## **Details**
- End-users can register.
    - Registration information: email address, password
- Landing page shows all accepted pictures' URLs
    - NON-logged in users can click on the links to see the pictures
- Logged in users can upload a picture along with following fields:
    - description
    - category
        - only three fixed categories: living thing, machine, nature
    - attachment (up to 2 Mb) (jpg, png, gif only)
- An administrative user can login to a separate admin page
    - built-in admin with username "admin" and password "admin123"
    - built-in user with username "user" and password "user123"
- Administrative user sees list of uploaded pictures
    - list of all uploaded, unprocessed pictures
        - anything that was accepted or rejected does not show up here
- Admin can select a picture to process it
    - opens a new page showing description, category, picture dimensions, and displays picture
        - has two buttons "Accept", "Reject"
    - if "Accept" is pressed, a URL is autogenerated for that  picture, and can be
displayed on the Landing page
    - if "Reject" is pressed, the picture file is removed from storage and the data record marked as Rejected