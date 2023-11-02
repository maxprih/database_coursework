INSERT INTO "user" (login, password, name)
VALUES ('maxpri', 'maxpri_pass', 'Maxim Pri'),
       ('admin_user', 'adminpass', 'Sample Admin'),
       ('moder_user', 'moderpass', 'Sample Moderator');

INSERT INTO Role (role_name, user_id)
VALUES ('ROLE_USER', 1),
       ('ROLE_ADMIN', 2),
       ('ROLE_MODERATOR', 3);

INSERT INTO Balance (amount, user_id)
VALUES (1337, 1),
       (228, 2),
       (423, 3);

INSERT INTO Transaction (amount, user_id)
VALUES (100, 1),
       (-50, 1),
       (200, 1),
       (50, 2),
       (75, 3);

INSERT INTO Country (name)
VALUES ('Russia'),
       ('Germany'),
       ('Japan');

INSERT INTO Pokemon (name, health, damage, defense, country_id)
VALUES ('Pikachu', 100, 50, 30, 1),
       ('Bebra', 123, 200, 75, 1),
       ('Itmoshnik', 30, 1, 1000, 1),
       ('Charizard', 150, 80, 60, 2),
       ('Greninja', 120, 70, 40, 3);

INSERT INTO League (name, start_date, end_date)
VALUES ('ITMO League', '2023-01-01', '2023-11-28'),
       ('SPB League', '2022-03-01', '2023-12-25'),
       ('Russia League', '2023-05-01', '2023-09-30');

INSERT INTO Match (first_player_id, second_player_id, date, league_id, country_id)
VALUES (2, 3, '2023-02-15', 1, 1),
       (1, 3, '2023-04-15', 1, 2),
       (2, 1, '2023-04-10', 2, 3),
       (4, 5, '2023-06-20', 3, 1);

INSERT INTO Match_Event (name, coefficient, match_id)
VALUES ('Победа первого', 1.7, 1),
       ('Победа второго', 2.1, 1),
       ('Победа первого', 1.4, 2),
       ('Победа второго', 2.7, 2),
       ('Победа первого', 1.85, 3),
       ('Победа второго', 1.85, 3),
       ('Победа первого', 1.3, 4),
       ('Победа второго', 3.1, 4);

INSERT INTO Match_Event (name, coefficient, match_id, status)
VALUES ('Нокаут произошел', 7.5, 1, 'WIN'),
       ('Были выбиты зубы', 17.34, 4, 'LOSE'),
       ('Нокаут не произошел', 1.15, 2, 'WIN'),
       ('Сломана челюсть', 3.5, 3, 'WIN');

INSERT INTO Bet (amount, date, user_id)
VALUES (100, '2023-02-14', 1),
       (50, '2023-04-09', 1),
       (50, '2023-04-09', 1),
       (75, '2023-06-19', 1),
       (200, '2023-05-19', 1),
       (250, '2023-06-19', 1),
       (350, '2023-06-23', 1),
       (50, '2023-06-18', 1),
       (253, '2023-06-18', 1);

INSERT INTO Match_Event_Bet (match_event_id, bet_id)
VALUES (1, 1),
       (4, 2),
       (5, 3),
       (8, 4);

-- WIN EXPRESS BET
INSERT INTO Match_Event_Bet (match_event_id, bet_id)
VALUES (9, 7),
       (12, 7);

-- WIN REGULAR BET
INSERT INTO Match_Event_Bet (match_event_id, bet_id)
VALUES (11, 8);

-- LOSE EXPRESS BET
INSERT INTO Match_Event_Bet (match_event_id, bet_id)
VALUES (9, 5),
       (10, 5);

-- LOSE REGULAR BET
INSERT INTO Match_Event_Bet (match_event_id, bet_id)
VALUES (10, 6);

INSERT INTO Match_Event_Bet (match_event_id, bet_id)
VALUES (3, 9),
       (5, 9),
       (7, 9);