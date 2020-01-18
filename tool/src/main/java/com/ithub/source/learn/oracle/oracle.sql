-- sequence
CREATE SEQUENCE seq_name MINVALUE 1 NOMAXVALUE INCREMENT BY 1 CACHE 2;

-- 查找相关表
select a.COLUMN_NAME,a.DATA_TYPE,a.TABLE_NAME  from user_tab_columns  where a.user_tab_columns like '%字段名%';
