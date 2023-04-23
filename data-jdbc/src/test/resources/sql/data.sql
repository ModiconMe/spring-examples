INSERT INTO account(id, username, email, password, bio, image)
VALUES (1, 'username1', 'email1@mail.com', 'password1', 'long bio1', '/cloud/photos/1'),
       (2, 'username2', 'email2@mail.com', 'password2', 'long bio2', '/cloud/photos/2'),
       (3, 'username3', 'email3@mail.com', 'password3', 'long bio3', '/cloud/photos/3'),
       (4, 'username4', 'email4@mail.com', 'password4', 'long bio4', '/cloud/photos/4'),
       (5, 'username5', 'email5@mail.com', 'password5', 'long bio5', '/cloud/photos/5');

INSERT INTO account_relation(id_followee, id_follower)
VALUES (1, 2), (1, 3), (1, 5),
       (2, 1), (2, 4), (2, 5),
       (3, 1), (3, 2), (3, 5),
       (5, 1), (5, 2), (5, 4);