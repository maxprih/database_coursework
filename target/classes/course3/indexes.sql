CREATE INDEX idx_user_login ON "user" USING hash (login);

-- CREATE INDEX idx_balance_user_id ON Balance USING hash (user_id);

CREATE INDEX idx_match_league_id ON Match USING hash (league_id);

CREATE INDEX idx_match_event_match_id ON Match_Event USING hash (match_id);

CREATE INDEX idx_bet_user_id ON Bet USING hash (user_id);

-- CREATE INDEX idx_match_event_bet_ids ON Match_Event_Bet (match_event_id, bet_id);
