 INSERT INTO client (CLIENT_ID,CLIENT_NUMBER,EMAIL,FIRSTNAME,PASSWORD,ROLE,SURNAME) VALUES
                    (1,10,'client1@gmail.com','client1_N','client1','ROLE_CLIENT','client1_SN');
                     INSERT INTO client (CLIENT_ID,CLIENT_NUMBER,EMAIL,FIRSTNAME,PASSWORD,ROLE,SURNAME) VALUES
                    (2,20,'client12@gmail.com','client2_N','client2','ROLE_CLIENT','client2_SN');
INSERT INTO Account (ACCOUNT_ID,ACCOUNT_NUMBER,ACCOUNT_POSITION,CLIENT_ID) VALUES (1,52810848,11,1);
INSERT INTO Account (ACCOUNT_ID,ACCOUNT_NUMBER,ACCOUNT_POSITION,CLIENT_ID) VALUES (2,92810849,22,2);

INSERT INTO OPERATION (OPERATION_ID,BALANCE,OPERATION_DATE,OPERATION_TYPE,OPERATION_VALUE,ACCOUNT_ID ) VALUES (1,0,'2022-05-03T01:44:31.194+00:00','deposit',552,1 );
