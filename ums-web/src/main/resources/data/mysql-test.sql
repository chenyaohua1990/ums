DROP TABLE language_code;
CREATE TABLE language_code (language_id bigint NOT NULL COMMENT '国际化表id', code varchar(120) NOT NULL COMMENT '编码', value text NOT NULL COMMENT '值', version varchar(20) NOT NULL COMMENT '版本号', language varchar(10) NOT NULL COMMENT '语言种类', create_date datetime NOT NULL COMMENT '创建时间', update_date datetime NOT NULL COMMENT '最后更新时间', PRIMARY KEY (language_id), CONSTRAINT language_code_PK UNIQUE (code, version, language), INDEX AK_Key_1 (code, version, language)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='国际化表';
DROP TABLE lookup;
CREATE TABLE lookup (lookup_id bigint NOT NULL COMMENT 'lookup id', lookup_code char(100) NOT NULL, lookup_name varchar(500) NOT NULL, version varchar(20) COMMENT '版本号', describe_info text COMMENT '描述', create_date datetime NOT NULL COMMENT '创建时间', update_date datetime NOT NULL COMMENT '最后更新时间', PRIMARY KEY (lookup_id), CONSTRAINT AK_Key_3 UNIQUE (lookup_code), CONSTRAINT AK_Key_2 UNIQUE (lookup_code, version)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE lookup_item;
CREATE TABLE lookup_item (lookup_item_id bigint NOT NULL COMMENT 'lookup节点ID', lookup_id bigint COMMENT 'lookup id', lookup_item_code varchar(500) NOT NULL COMMENT 'lookup节点编号', lookup_item_name varchar(500) NOT NULL COMMENT 'lookup节点名称', language varchar(10) NOT NULL COMMENT '语言种类', version varchar(20) NOT NULL COMMENT '版本号', describe_info text COMMENT '描述', create_date datetime NOT NULL COMMENT '创建时间', update_date datetime NOT NULL COMMENT '最后更新时间', PRIMARY KEY (lookup_item_id), INDEX FK_lookup_item_relations (lookup_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='LOOKUP节点';
DROP TABLE menu;
CREATE TABLE menu (menu_id bigint NOT NULL COMMENT '菜单ID', right_id bigint COMMENT '权限ID', parent_menu_id bigint COMMENT '上级菜单ID', name varchar(20) NOT NULL COMMENT '名称', url varchar(200) NOT NULL COMMENT '路径', create_date datetime NOT NULL COMMENT '创建时间', describe_info text COMMENT '描述', update_date datetime NOT NULL COMMENT '最后更新时间', PRIMARY KEY (menu_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';
DROP TABLE resources;
CREATE TABLE resources (resources_id bigint NOT NULL COMMENT '资源ID', resources_type int NOT NULL COMMENT '资源类型', resources_name varchar(100) NOT NULL COMMENT '资源名称', describe_info text COMMENT '描述', create_date datetime NOT NULL COMMENT '创建时间', update_date datetime NOT NULL COMMENT '最后更新时间', PRIMARY KEY (resources_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';
DROP TABLE right_group_relations;
CREATE TABLE right_group_relations (group_id bigint NOT NULL COMMENT '组ID', right_id bigint NOT NULL COMMENT '权限ID', PRIMARY KEY (group_id, right_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限组表';
DROP TABLE right_resources_relation;
CREATE TABLE right_resources_relation (right_id bigint NOT NULL COMMENT '权限ID', resources_id bigint NOT NULL COMMENT '资源ID', PRIMARY KEY (right_id, resources_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限与资源关系';
DROP TABLE role_group_relations;
CREATE TABLE role_group_relations (group_id bigint NOT NULL COMMENT '组ID', role_id bigint NOT NULL COMMENT '角色ID', PRIMARY KEY (group_id, role_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限组关系表';
DROP TABLE role_right_relations;
CREATE TABLE role_right_relations (role_id bigint NOT NULL COMMENT '角色ID', right_id bigint NOT NULL COMMENT '权限ID', PRIMARY KEY (role_id, right_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';
DROP TABLE sequence;
CREATE TABLE sequence (tablename varchar(30) NOT NULL COMMENT '表名', nextid bigint NOT NULL COMMENT '下一个ID', PRIMARY KEY (tablename)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主键生成表';
DROP TABLE t_group;
CREATE TABLE t_group (group_id bigint NOT NULL COMMENT '组ID', group_name varchar(40) NOT NULL COMMENT '组名称', create_date datetime NOT NULL COMMENT '创建时间', update_date datetime NOT NULL COMMENT '最后更新时间', describe_info text COMMENT '描述', PRIMARY KEY (group_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组表';
DROP TABLE t_organization;
CREATE TABLE t_organization (t_organization_id bigint NOT NULL COMMENT '组织ID', parent_organization_id bigint COMMENT '上级组织ID', organization_name varchar(100) NOT NULL COMMENT '组织名称', create_date datetime COMMENT '创建时间', update_date datetime COMMENT '最后更新时间', describe_info text COMMENT '描述', PRIMARY KEY (t_organization_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织表';
DROP TABLE t_right;
CREATE TABLE t_right (right_id bigint NOT NULL COMMENT '权限ID', menu_id bigint COMMENT '菜单ID', create_date datetime NOT NULL COMMENT '创建时间', describe_info text COMMENT '描述', update_date datetime NOT NULL COMMENT '最后更新时间', right_name varchar(40) NOT NULL COMMENT '权限名称', PRIMARY KEY (right_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';
DROP TABLE t_role;
CREATE TABLE t_role (role_id bigint NOT NULL COMMENT '角色ID', parent_role_id bigint, role_name varchar(10) NOT NULL COMMENT '角色名称', create_date datetime NOT NULL COMMENT '创建时间', update_date datetime NOT NULL COMMENT '最后更新时间', describe_info text COMMENT '描述', PRIMARY KEY (role_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
DROP TABLE t_user;
CREATE TABLE t_user (user_id bigint NOT NULL COMMENT '用户ID', user_name varchar(30) NOT NULL COMMENT '用户名', password varchar(100) NOT NULL COMMENT '用户密码', email varchar(40) NOT NULL COMMENT '邮箱', token varchar(150) COMMENT 'token', salt varchar(40) NOT NULL COMMENT '盐', create_date datetime NOT NULL COMMENT '创建时间', update_date datetime NOT NULL COMMENT '最后更新时间', PRIMARY KEY (user_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
DROP TABLE user_group_relations;
CREATE TABLE user_group_relations (user_id bigint NOT NULL COMMENT '用户ID', group_id bigint NOT NULL COMMENT '组ID', PRIMARY KEY (user_id, group_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组关系表';
DROP TABLE user_organization;
CREATE TABLE user_organization (user_id bigint NOT NULL COMMENT '用户ID', t_organization_id bigint NOT NULL COMMENT '组织ID', PRIMARY KEY (user_id, t_organization_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组织表';
DROP TABLE user_right_relations;
CREATE TABLE user_right_relations (user_id bigint NOT NULL COMMENT '用户ID', right_id bigint NOT NULL COMMENT '权限ID', PRIMARY KEY (user_id, right_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表';
DROP TABLE user_role_relations;
CREATE TABLE user_role_relations (user_id bigint NOT NULL COMMENT '用户ID', role_id bigint NOT NULL COMMENT '角色ID', PRIMARY KEY (user_id, role_id)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色用户关联表';
ALTER TABLE `lookup_item` ADD CONSTRAINT FK_lookup_item_relations FOREIGN KEY (`lookup_id`) REFERENCES `lookup` (`lookup_id`);
DROP FUNCTION nextId;

CREATE DEFINER=`root`@`localhost` FUNCTION nextId(table_name varchar(100)) RETURNS bigint(20)
begin
        declare next_id bigint default 0;
        UPDATE SEQUENCE SET nextid=nextid+1 WHERE upper(tablename)=upper(table_name);
        select nextid  from SEQUENCE WHERE tablename=table_name into next_id;
        RETURN next_id;
end

