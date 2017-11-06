CREATE TABLE BorrowedBooks(
id INT PRIMARY KEY AUTO_INCREMENT,
bookid INT,
FOREIGN KEY (bookid) references Books(id),
userid INT,
FOREIGN KEY (userid) references Users(id),
startdate DATE,
duedate DATE,
returndate DATE
);