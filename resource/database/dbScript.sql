

 sudo mysql -u root
passwd=masoud
CREATE DATABASE okmdb DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;
CREATE USER openkm@localhost IDENTIFIED BY 'openkm';
GRANT ALL ON okmdb.* TO openkm@localhost WITH GRANT OPTION;

CREATE TABLE `masoud` (
  `userName` varchar(50) DEFAULT NULL,
 
 `password` varchar(20) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
 
 `language` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `mm_document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `filename` varchar(200) DEFAULT NULL,
  `document_class` varchar(45) DEFAULT NULL,
  `document_type` varchar(45) DEFAULT NULL,
  `time_inserted` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `source_systemid` varchar(45) DEFAULT NULL,
  `personnummer` varchar(12) DEFAULT NULL,
  `customerid` varchar(20) DEFAULT NULL,
  `skadenummer` varchar(20) DEFAULT NULL,
  `sourcesystem_name` varchar(45) DEFAULT NULL,
  `policy_number` varchar(45) DEFAULT NULL,
  `handledare_name` varchar(120) DEFAULT NULL,
  `department` varchar(120) DEFAULT NULL,
  `varumarke` varchar(45) DEFAULT NULL,
  `sekundar_varumarke` varchar(45) DEFAULT NULL,
  `gallringstyp_nr` int(11) DEFAULT NULL,
  `gallrings_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

 select name,filename,document_class,time_inserted,personnummer,skadenummer,policy_number,varumarke,department,customerid from mm_document;


SELECT  @rownum := @rownum + 1 AS no,t.name,t.time_inserted,t.personnummer,t.skadenummer,t.policy_number,t.varumarke,t.customerid  FROM mm_document t , (SELECT @rownum := 0) t;


create table mm_access_controllist (ad_id varchar(100) not null primary key,
 title varchar(100) not null ,
 owner_control char(1) not null default 'N',
 modify_content char(1) not null default 'N',
 modify_metadata char(1) not null default 'N',
view_content char(1) not null default 'N',
 view_metadata char(1) not null default 'N', 
 publish char(1) not null default 'N',
 remove char(1) not null default 'N') ;

insert into mm_access_controllist values('CPE_FOLKSAM_EKONOMI_ADMIN', 'Ekonomi chef','Y','Y','Y','Y','Y','Y','N');

drop table  mm_access_controllist ;


insert into mm_access_controllist values('CPE_FOLKSAM_EKONOMI_ANSTALLD', 'Ekonomi anstalld','N','N','N','Y','Y','Y','N');


---------------------------2019-04-14-----------------
CREATE TABLE `mm_access_controllist` (
  `title` varchar(100) NOT NULL,
  `owner_control` char(1) NOT NULL DEFAULT 'N',
  `modify_content` char(1) NOT NULL DEFAULT 'N',
  `modify_metadata` char(1) NOT NULL DEFAULT 'N',
  `view_content` char(1) NOT NULL DEFAULT 'N',
  `view_metadata` char(1) NOT NULL DEFAULT 'N',
  `publish` char(1) NOT NULL DEFAULT 'N',
  `remove` char(1) NOT NULL DEFAULT 'N',
  `acl_id` int(11) NOT NULL,
  PRIMARY KEY (`acl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `mm_ad_group` (
  `id` varchar(40) NOT NULL,
  `company` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `mm_config` (
  `id` varchar(100) NOT NULL,
  `val` varchar(255) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `mm_document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `filename` varchar(200) NOT NULL,
  `document_class` varchar(45) NOT NULL,
  `document_type` varchar(45) DEFAULT NULL,
  `time_inserted` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `source_systemid` varchar(45) NOT NULL,
  `personnummer` varchar(12) DEFAULT NULL,
  `customerid` varchar(20) DEFAULT NULL,
  `skadenummer` varchar(20) DEFAULT NULL,
  `sourcesystem_name` varchar(45) DEFAULT NULL,
  `policy_number` varchar(45) DEFAULT NULL,
  `handledare_name` varchar(120) DEFAULT NULL,
  `department` varchar(120) NOT NULL,
  `varumarke` varchar(45) NOT NULL,
  `sekundar_varumarke` varchar(45) DEFAULT NULL,
  `gallringstyp_nr` int(11) DEFAULT NULL,
  `gallrings_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `owner_id` varchar(10) DEFAULT NULL,
  `yta` varchar(45) NOT NULL,
  `security_class` int(6) DEFAULT '1000',
  PRIMARY KEY (`id`),
  KEY `doc_class_fk_idx` (`document_class`),
  KEY `security_acl_fk_idx` (`security_class`),
  CONSTRAINT `doc_class_fk` FOREIGN KEY (`document_class`) REFERENCES `mm_document_class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `security_acl_fk` FOREIGN KEY (`security_class`) REFERENCES `mm_access_controllist` (`acl_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8;

CREATE TABLE `mm_document_class` (
  `description` varchar(20) DEFAULT 'not nul',
  `id` varchar(45) NOT NULL DEFAULT 'not NULL',
  `digit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `mm_user_adgroup` (
  `ad_id` varchar(40) NOT NULL,
  `personr` varchar(12) NOT NULL,
  `varumarke` varchar(45) NOT NULL,
  `YTA` varchar(45) NOT NULL,
  `texten` varchar(50) DEFAULT NULL,
  `user_string` varchar(20) NOT NULL,
  PRIMARY KEY (`ad_id`,`personr`),
  CONSTRAINT `adgrpid_fk` FOREIGN KEY (`ad_id`) REFERENCES `mm_ad_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
