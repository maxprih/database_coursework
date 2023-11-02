DROP TRIGGER check_match_date_within_league_date_trigger ON match;

DROP TRIGGER update_bet_status_trigger ON match_event;

DROP FUNCTION check_match_date_within_league_date();

DROP FUNCTION update_bet_status();

DROP TABLE match_event_bet CASCADE;

DROP TABLE match_event CASCADE;

DROP TABLE balance CASCADE;

DROP TABLE league CASCADE;

DROP TABLE match CASCADE;

DROP TABLE transaction CASCADE;

DROP TABLE role CASCADE;

DROP TABLE bet CASCADE;

DROP TABLE "user" CASCADE;

DROP TABLE pokemon CASCADE;

DROP TABLE country CASCADE;

DROP TYPE match_event_status CASCADE;

DROP TYPE bet_status CASCADE;

DROP FUNCTION is_express_bet;

DROP FUNCTION calculate_bet_winnings(curr_bet_id integer);

DROP FUNCTION calculate_total_coefficient(curr_bet_id integer);

DROP FUNCTION is_bet_won(curr_bet_id integer);

DROP FUNCTION get_matches_within_24_hours();