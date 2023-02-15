# JdbcBasics
use ContactDb;
create table game(
game_id int auto_increment primary key,
game_name varchar(50) not null,
number_of_players int not null
);
desc game;
select * from game;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_game`(in gameId int ,IN gameName VARCHAR(15), IN numberofplayers int)
BEGIN
update game set game_name=gameName,number_of_players=numberofplayers where game_id = gameId;
END$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_game`(IN game_name VARCHAR(15), IN number_of_players int)
BEGIN
 insert into game (game_name,number_of_players)
  VALUES (game_name,number_of_players );
END$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_game`(in gameId int)
BEGIN
delete from game where game_id = gameId;
END$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `find_game`(in p_game_id int)
BEGIN
	SELECT * FROM game WHERE game_id = p_game_id;
END$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `findAll_game`()
BEGIN
select * from game;
END$$
DELIMITER ;
