CREATE DATABASE mm_dok DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;
CREATE USER mm_dok@localhost IDENTIFIED BY 'mm_dok';
GRANT ALL ON mm_dok.* TO mm_dok@localhost WITH GRANT OPTION;

gcloud sql connect mmdok --user=root --quiet

CREATE TABLE `doc` (
  `id` varchar(36) NOT NULL,
  `doktype` varchar(20) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `docsize` int(11) DEFAULT NULL,
  `sold` tinyint(1) DEFAULT NULL,
  `personnummer` varchar(12) DEFAULT NULL,
  `skadenummer` varchar(30) DEFAULT NULL,
  `customerid` varchar(45) DEFAULT NULL,
  `varumarke` varchar(45) DEFAULT NULL,
  `sekundar_varumarke` varchar(45) DEFAULT NULL,
  `bucket_name` varchar(45) DEFAULT NULL,
  `document_class` varchar(45) DEFAULT NULL,
  `source_systemid` varchar(45) DEFAULT NULL,
  `gallrings_date` datetime DEFAULT NULL,
  `time_inserted` datetime DEFAULT CURRENT_TIMESTAMP,
  `filename` varchar(200) DEFAULT NULL,
  `generated_filename` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `masoud` (
  `userName` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `language` varchar(10) DEFAULT NULL,
  `inserttime` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `mm_document_class` (
  `description` varchar(20) DEFAULT 'not nul',
  `id` varchar(45) NOT NULL DEFAULT 'not NULL',
  `security_level` smallint(6) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
)

CREATE TABLE `mm_adgrpup_docclass` (
  `ad_id` varchar(40) NOT NULL,
  `docclass` varchar(40) NOT NULL,
  `acl_id` int(11) NOT NULL,
  PRIMARY KEY (`ad_id`,`docclass`,`acl_id`),
  KEY `docclass_fk_idx` (`docclass`),
  KEY `ackid_fk_idx` (`acl_id`),
  CONSTRAINT `ackid_fk` FOREIGN KEY (`acl_id`) REFERENCES `mm_access_controllist` (`acl_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `adgrp_fk` FOREIGN KEY (`ad_id`) REFERENCES `mm_ad_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `docclass_fk` FOREIGN KEY (`docclass`) REFERENCES `mm_document_class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `gallringstyp_nr` int(11) DEFAULT '1',
  `gallrings_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `owner_id` varchar(10) DEFAULT NULL,
  `yta` varchar(45) NOT NULL,
  `dokid` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid_UNIQUE` (`dokid`),
  KEY `doc_class_fk_idx` (`document_class`),
  KEY `gallring_id_fk_idx` (`gallringstyp_nr`),
  CONSTRAINT `doc_class_fk` FOREIGN KEY (`document_class`) REFERENCES `mm_document_class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `gallring_id_fk` FOREIGN KEY (`gallringstyp_nr`) REFERENCES `mm_gallring` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=101910 DEFAULT CHARSET=utf8;

 ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `mm_gallring` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_description` varchar(45) DEFAULT NULL,
  `number_of_days` int(11) DEFAULT NULL,
  `makulation_princip` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `mm_user_adgroup` (
  `ad_id` varchar(40) NOT NULL,
  `personr` varchar(12) NOT NULL,
  `varumarke` varchar(45) NOT NULL,
  `YTA` varchar(45) NOT NULL,
  `texten` varchar(50) DEFAULT NULL,
  `user_string` varchar(20) NOT NULL,
  PRIMARY KEY (`ad_id`,`user_string`),
  CONSTRAINT `adgrpid_fk` FOREIGN KEY (`ad_id`) REFERENCES `mm_ad_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `uid` int(20) NOT NULL AUTO_INCREMENT,
  `uname` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


DELIMITER |
CREATE TRIGGER ADDID_DOC BEFORE INSERT ON doc FOR EACH ROW
 BEGIN
 IF new.id IS NULL THEN
    SET new.id = (SELECT UUID());
  END IF;
END

DELIMITER;



insert into doc(filename,document_class,source_systemid,personnummer,skadenummer,varumarke, customerid, year, doktype,color,bucket_name,generated_filename) 
values('/home/ubuntu/dokmentplatsen/HD84FKUI_18535422.pdf','SKADEANMALAN','A561','201905105050',
'CLA-476135SK','FOLKSAM','CUS-8271183HS','2016','SKADEANMALAN','Black','SKADEANMALAN','6WNKG349SO0M55CYPM8OTCOZVL842TFW1ZC5');


INSERT INTO `users` VALUES (1,'adam','adam'),(2,'masoud','masoud');


INSERT INTO `mm_ad_group` VALUES ('CPE_FOLKSAM_DJURSKADOR_RW','FOLKSAM','RISK'),('CPE_FOLKSAM_EKONOMI_ADMIN','FOLKSAM','EKONOMI'),('CPE_FOLKSAM_EKONOMI_META','FOLKSAM','EKONOMI'),('CPE_FOLKSAM_EKONOMI_READ','FOLKSAM','EKONOMI'),('CPE_FOLKSAM_EKONOMI_RW','FOLKSAM','EKONOMI'),('CPE_FOLKSAM_LIVSFORSAKRING_RW','FOLKSAM','FORSAKRING'),('CPE_FOLKSAM_LPSHANDLINGAR_RW','FOLKSAM','FORSAKRING'),('CPE_FOLKSAM_RISK_ADMIN','FOLKSAM','SKADOR'),('CPE_FOLKSAM_RISK_META','FOLKSAM','SKADOR'),('CPE_FOLKSAM_RISK_READ','FOLKSAM','SKADOR'),('CPE_FOLKSAM_RISK_RW','FOLKSAM','SKADOR'),('CPE_FOLKSAM_SKADOR_ADMIN','FOLKSAM','BIL_FORSAKRING'),('CPE_FOLKSAM_SKADOR_META','FOLKSAM','BIL_FORSAKRING'),('CPE_FOLKSAM_SKADOR_READ','FOLKSAM','BIL_FORSAKRING'),('CPE_FOLKSAM_SKADOR_RW','FOLKSAM','BIL_FORSAKRING'),('CPE_KPA_SKADOR','KPA','SKADOR');




INSERT INTO `mm_user_adgroup` VALUES ('CPE_FOLKSAM_DJURSKADOR_RW','198009015080','FOLKSAM','DJURSKADOR','Djur-skador','FOGS20'),('CPE_FOLKSAM_EKONOMI_ADMIN','198009015080','FOLKSAM','EKONOMI',NULL,'FGMB21'),('CPE_FOLKSAM_EKONOMI_META','199005014050','FOLKSAM','EKONOMI',NULL,'MNAS33'),('CPE_FOLKSAM_EKONOMI_READ','198001011213','FOLKSAM','EKONOMI',NULL,'AGDX67'),('CPE_FOLKSAM_EKONOMI_RW','197609124567','FOLKSAM','EKONOMI',NULL,'SDAA40'),('CPE_FOLKSAM_LIVSFORSAKRING_RW','198009015080','FOLKSAM','LIVSFÖRSÄKRINGAR','Livs-Försäkringar','BAFG56'),('CPE_FOLKSAM_LPSHANDLINGAR_RW','198009015080','FOLKSAM','LPSHANDLINGAR','Lps-Handlingar','ASMK90'),('CPE_FOLKSAM_RISK_ADMIN','200004132233','FOLKSAM','RISK',NULL,'AAFH66'),('CPE_FOLKSAM_RISK_META','197806013060','FOLKSAM','RISK',NULL,'AZNH10'),('CPE_FOLKSAM_RISK_READ','195404113214','FOLKSAM','RISK',NULL,'KALA70'),('CPE_FOLKSAM_RISK_RW','197810018090','FOLKSAM','RISK',NULL,'BADF16'),('CPE_FOLKSAM_SKADOR_ADMIN','195402211455','FOLKSAM','SKADOR',NULL,'CASK50'),('CPE_FOLKSAM_SKADOR_META','197609101156','FOLKSAM','SKADOR',NULL,'KADG80'),('CPE_FOLKSAM_SKADOR_READ','197807014080','FOLKSAM','SKADOR',NULL,'MNAS33'),('CPE_FOLKSAM_SKADOR_RW','196508174132','FOLKSAM','FOLKSAM',NULL,'PARK80');




INSERT INTO `mm_gallring` VALUES (1,'faktura',90,'720'),(2,'polis_anmalan',1500,'5000');





INSERT INTO `mm_document_class` VALUES ('claim','CLAIM',1),('correspondence','CORRESPODENT',1),('betalning faktura','FAKTURA',1),('försäkring','FORSAKRING',1),('kundhandling','HANDLING',1),('individuell','INDIVIDUELL',1),('kollective','KOLLEKTIV',1),('policy type','POLICY',1),('polis anmälan','POLISANMALAN',1),('skadeanmälan','SKADEANMALAN',1),('sparande','SPARANDE',1);





INSERT INTO `mm_access_controllist` VALUES ('empolyee','N','N','Y','Y','Y','N','N',1000),('employee minimum','N','N','N','Y','Y','N','N',1001),('employee limited','N','N','N','N','Y','N','N',1002),('full controll','Y','Y','Y','Y','Y','Y','N',2000);



INSERT INTO `mm_adgrpup_docclass` VALUES ('CPE_FOLKSAM_EKONOMI_META','FAKTURA',1000),('CPE_FOLKSAM_SKADOR_READ','CLAIM',1000);


