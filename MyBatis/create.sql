CREATE TABLE employee (id INT, name VARCHAR(100),surname VARCHAR(20), title VARCHAR(10), created DATE);

CREATE TABLE `proc` (
  `PROC_ID` bigint(20) NOT NULL COMMENT 'L''id e-Curia de la procédure. ',
  `PROC_ID_LITIGE` varchar(100) DEFAULT NULL,
  `PROC_ID_LITIGE_PROCEDURE` varchar(100) DEFAULT NULL,
  `PROC_ID_PUBLIE` varchar(20) NOT NULL COMMENT 'Correspond à l''id publié de la procédure.\n',
  `PROC_AFF_ID` double DEFAULT NULL,
  `PROC_NOM_USUEL` varchar(120) NOT NULL COMMENT 'Correspond au nom usuel de l''affaire à laquelle appartient la procédure.\nLa donnée de référence provient de la base de données Litige, Table LA_AFF, colonne LCL_NOMUSUEL.',
  `PROC_CODE_LANGUE_PROCEDURE` varchar(10) NOT NULL COMMENT 'Correspond au code langue de la langue de procédure de l''affaire. A l''heure actuelle dans litige, une seule langue de procédure est possible dans l''application LITIGE.\n',
  `PROC_NODE` varchar(255) NOT NULL COMMENT 'Correspond à l''identifiant unique du noeud Alfresco Extranet dans l''espace Affair.\nCet identifiant est stocké sous forme de chaîne de caractères.\n\nExemple de référence de noeud stockée : "workspace://SpacesStore/25b4951d-fae7-4ad0-b662-f7d948a1e935"',
  `PROC_CODE_ETAT` varchar(10) NOT NULL,
  `PROC_PILOTE` varchar(1) DEFAULT NULL,
  `PROC_DATE_DER_MAJ` datetime DEFAULT NULL,
  PRIMARY KEY (`PROC_ID`),
  UNIQUE KEY `ID_PROC_ID` (`PROC_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `proc_container` (
  `ID` int(11) NOT NULL,
  `PROC_ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE user (
  user_id int(10) unsigned NOT NULL auto_increment,
  email_id varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) default NULL,
  blog_id int(10) unsigned default NULL,
  PRIMARY KEY  (user_id),
  UNIQUE KEY Index_2_email_uniq (email_id),
  KEY FK_user_blog (blog_id),
  CONSTRAINT FK_user_blog FOREIGN KEY (blog_id) REFERENCES blog (blog_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE blog (
  blog_id int(10) unsigned NOT NULL auto_increment,
  blog_name varchar(45) NOT NULL,
  created_on datetime NOT NULL,
  PRIMARY KEY  (blog_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE post (
  post_id int(10) unsigned NOT NULL auto_increment,
  title varchar(45) NOT NULL,
  content varchar(1024) NOT NULL,
  created_on varchar(45) NOT NULL,
  blog_id int(10) unsigned NOT NULL,
  PRIMARY KEY  (post_id),
  KEY FK_post_blog (blog_id),
  CONSTRAINT FK_post_blog FOREIGN KEY (blog_id) REFERENCES blog (blog_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;