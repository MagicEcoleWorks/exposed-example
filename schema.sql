CREATE TABLE `com_code_info` (
                                 `code_id` varchar(3) NOT NULL AUTO_INCREMENT COMMENT '코드ID|코드ID|',
                                 `code_name` varchar(64) NOT NULL COMMENT '코드명|코드명|',
                                 `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시|생성일시|',
                                 `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '생성일시|생성일시|',
                                 PRIMARY KEY (`code_id`),
                                    -- TODO 이건...어떻게...? 여기도 원래 UNIQUE 가 있었다.
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='공통코드정보|공통코드정보|';


CREATE TABLE `com_code_group` (
                                  `code_group_id` varchar(4) NOT NULL COMMENT '코드그룹ID|코드그룹ID|',
                                  `code_group_name` varchar(100) NOT NULL COMMENT '코드그룹명|코드그룹명|',
                                  `parent_code_group_id` varchar(4) DEFAULT NULL COMMENT '상위코드그룹ID|상위코드그룹ID|',
                                  `description` varchar(200) DEFAULT NULL COMMENT '설명|설명|',
                                  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시|생성일시|',
                                  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시|수정일시|',
                                  PRIMARY KEY (`code_group_id`),
                                  UNIQUE KEY `com_code_group_ux01` (`code_group_name`), -- TODO 이건...어떻게...?
                                  KEY `com_code_group_fk01` (`parent_code_group_id`),
                                  CONSTRAINT `com_code_group_fk01` FOREIGN KEY (`parent_code_group_id`) REFERENCES `com_code_group` (`code_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='공통코드그룹|공통 코드에 대한 그룹|';


CREATE TABLE `com_code_group_history` (
                                          `code_group_id` varchar(4) NOT NULL COMMENT '코드그룹ID|com_code_group.id|',
                                          `code_validity_start_date` date NOT NULL COMMENT '코드유효시작일자|코드유효시작일자|',
                                          `code_validity_end_date` date NOT NULL COMMENT '코드유효종료일자|코드유효종료일자|',
                                          `code_group_name` varchar(50) NOT NULL COMMENT '코드그룹명|코드그룹명|',
                                          `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시|생성일시|',
                                          `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시|수정일시|',
                                          PRIMARY KEY (`code_group_id`,`code_validity_start_date`), -- TODO 이건...어떻게...?
                                          CONSTRAINT `com_code_group_history_fk01` FOREIGN KEY (`code_group_id`) REFERENCES `com_code_group` (`code_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='공통dj코드그룹이력';


CREATE TABLE `com_code` (
                            `code_group_id` varchar(4) NOT NULL COMMENT '코드그룹ID|com_code_group.id|',
                            `code_id` varchar(3) NOT NULL COMMENT '코드ID|com_code_info.id|',
                            `use_yn` tinyint(1) NOT NULL COMMENT '사용여부|사용여부|',
                            `description` varchar(200) DEFAULT NULL COMMENT '설명|설명|',
                            `sorting_number` int(5) NOT NULL COMMENT '정렬번호|코드그룹별 정렬번호를 생성|',
                            `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시|생성일시|',
                            `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '생성일시|생성일시|',
                            PRIMARY KEY (`code_group_id`,`code_id`),
                            KEY `com_code_fk02` (`code_id`),
                            CONSTRAINT `com_code_fk01` FOREIGN KEY (`code_group_id`) REFERENCES `com_code_group` (`code_group_id`),
                            CONSTRAINT `com_code_fk02` FOREIGN KEY (`code_id`) REFERENCES `com_code_info` (`code_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='공통코드|공통 코드|';
