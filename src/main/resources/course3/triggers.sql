DROP TRIGGER IF EXISTS check_match_date_within_league_date_trigger ON match;
CREATE TRIGGER check_match_date_within_league_date_trigger
    BEFORE INSERT
    ON Match
    FOR EACH ROW
EXECUTE FUNCTION check_match_date_within_league_date();


DROP TRIGGER IF EXISTS update_bet_status_trigger ON match_event;
CREATE TRIGGER update_bet_status_trigger
    AFTER UPDATE
    ON Match_Event
    FOR EACH ROW
    WHEN (OLD.status IS DISTINCT FROM NEW.status)
EXECUTE FUNCTION update_bet_status();

DROP TRIGGER IF EXISTS before_insert_bet ON bet;
CREATE TRIGGER before_insert_bet
    BEFORE INSERT
    ON Bet
    FOR EACH ROW
EXECUTE FUNCTION check_bet_amount();