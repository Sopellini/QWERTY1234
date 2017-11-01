Insert into Privilige(Privilige_ID, Privilige) values (1, 'Moge wszystko');
Insert into Users(User_ID, Username, Password, Privilige_ID) values (1, 'admin', '4dm1n01', 1);
Insert into Contact(Contact_ID, Street, House_Number, Flat_Number, Postcode, City, Phone, Phone2, Email) values (1, 'Grunwaldzka', '234C', '5', '80-103', 'Gdańsk', '+48 345 50 22', '', 'luckyluck@wp.pl');
Insert into Insurance_Type(Ins_Type_ID, Ins_Type, Insurance_Amount, Cost, Payment_Type) values (1, 'Ubezpieczenie na życie', 300000.20, 2000.02, 'Jednorazowo');
Insert into Insurance(Insurance_ID, DateStart, DateEnd, Ins_Type_ID, Client_ID) values (1, TO_DATE('17/04/2021', 'DD/MM/YYYY'), TO_DATE('18/04/2021', 'DD/MM/YYYY'), 1, 1);
Insert into Client(Client_ID, Name, Name2, Surname, DOB, PESEL, Contact_ID, Insurance_ID) values (1, 'Jan', 'Stefan', 'Kowalski', TO_DATE('12/03/1980', 'DD/MM/YYYY'), 80031214599, 1, 1);
Insert into Client(Client_ID, Name, Surname, DOB, PESEL) values (2, 'Zenon', 'Nowak', TO_DATE('18/05/1956', 'DD/MM/YYYY'), 56051807554);

commit;