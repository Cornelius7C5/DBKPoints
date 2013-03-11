INSERT INTO salepoints(
            id_sp, "name")
    VALUES (0, 'Admin');
﻿INSERT INTO users(
            id_u, blocked_points, last_login, last_order_realization, last_points, 
            "name", "password", surname, id_register_point, id_role, id_work_sp)
    VALUES (1, 0, TIMESTAMP '2000-01-01 00:00:00', TIMESTAMP '2000-01-01 00:00:00', TIMESTAMP '2000-01-01 00:00:00', 
            'Dagobert Baldwin', 'admin', 'Krześmirski', ?, 111, 0);
