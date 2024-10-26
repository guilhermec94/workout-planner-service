INSERT INTO users
(id, first_name, last_name, email)
VALUES('2e97b683-1b68-406d-b101-533c347e67ea', 'UserFirstName', 'UserLastName', 'user@email.com');

INSERT INTO workouts
(id, "name", "owner", created_at)
VALUES('d81ef4cd-a6b3-4375-ba8d-467e5a50a988', 'Workout1', '2e97b683-1b68-406d-b101-533c347e67ea', '2023-10-25T15:30:00');