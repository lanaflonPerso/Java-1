DELETE FROM users
WHERE id NOT IN (SELECT uc.user_id
                   FROM users_contests uc);