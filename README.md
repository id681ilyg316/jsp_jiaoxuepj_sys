## 本项目实现的最终作用是基于JSP高校教学评价管理系统
## 分为3个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 修改密码
 - 学生管理
 - 教师管理
 - 管理员登录
 - 管理员管理
 - 评价指标管理
 - 评价结果查看
### 第2个角色为文稿截图，实现了如下功能：
 - 论文截图
### 第3个角色为学生角色，实现了如下功能：
 - 个人信息修改
 - 学生角色登录
 - 评价某一个老师
## 数据库设计如下：
# 数据库设计文档

**数据库名：** jiaoxuepj_sys

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [t_admin](#t_admin) | 管理员表 |
| [t_pingjia](#t_pingjia) |  |
| [t_pingxia_xuanxian](#t_pingxia_xuanxian) |  |
| [t_stu](#t_stu) |  |
| [t_tea](#t_tea) |  |
| [t_zhibiao](#t_zhibiao) |  |

**表名：** <a id="t_admin">t_admin</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | UserId |   int   | 10 |   0    |    N     |  Y   |       | 用户ID  |
|  2   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | userPw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |

**表名：** <a id="t_pingjia">t_pingjia</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   varchar   | 255 |   0    |    N     |  Y   |       | 主键ID  |
|  2   | tea_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | zongfenshu |   int   | 10 |   0    |    Y     |  N   |   NULL    | 总分  |
|  4   | shijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  5   | stu_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 学生ID  |

**表名：** <a id="t_pingxia_xuanxian">t_pingxia_xuanxian</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | zhibiao_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | fenshu |   int   | 10 |   0    |    Y     |  N   |   NULL    | 分数  |
|  4   | pingjia_id |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_stu">t_stu</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | xuehao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 学号  |
|  3   | name1 |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名称  |
|  4   | sex |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 性别  |
|  5   | age |   int   | 10 |   0    |    Y     |  N   |   NULL    | 年龄  |
|  6   | loginname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 登录名称  |
|  7   | loginpw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 登录密码  |
|  8   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_tea">t_tea</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | bianhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 编号  |
|  3   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  4   | sex |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 性别  |
|  5   | age |   int   | 10 |   0    |    Y     |  N   |   NULL    | 年龄  |
|  6   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_zhibiao">t_zhibiao</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | mingcheng |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名称  |
|  3   | fenshu |   int   | 10 |   0    |    Y     |  N   |   NULL    | 分数  |
|  4   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**运行不出来可以微信 javape 我的公众号：源码码头**
