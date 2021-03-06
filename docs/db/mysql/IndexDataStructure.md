# MySQL索引数据结构

索引是一种可以优化查询的数据结构,MySQL中的索引使用B+树实现的。  
[SQL优化总结](https://github.com/flushCoder/java-base_core/tree/master/docs/db/mysql/SQL-optimize.md)
### Hash 索引的特点(可以快速精确查询,不支持范围查询)  
Hash 索引只能够用于相等比较(速度更快)。Hash 索引不能够用于诸如 < 等用于查找一个范围值的比较运算符。依赖于这种单值查找的系统被称为 “键-值存储”；对于这种系统，尽可能地使用 hash 索引。  
查找某行记录必须进行全键匹配。而 B-tree 索引，任何该键的左前缀都可用以查找记录。 

### B+ Tree 的数据结构(默认每个节点存储1页的数据大小->16K)  
  相对于二叉树每个节点可以存储更多元素,相对于二叉树高度降低,减少磁盘I/O,并且叶子节点冗余元素、用指针连接,更方便范围查询(范围查询时不需要反向查询)  

  相对于B树,B+ Tree 的非叶子节点不存储数据只存元素,只有叶子节点储存元素和数据,而子B树的叶子节点和非叶节点都储存元素和数据  
  
### InnoDB中的B+树和MyiSAM中的B+树  
  InnoDB中叶子节点的数据区域储存的是真实的数据记录(聚集索引),因此InnoDB的查询效率要比MyiSAM的查询效率高(少一次I/O)
  ![](https://github.com/flushCoder/java-base_core/blob/master/picture/db/Innodb.jpg)
  MyiSAM中叶子节点的数据区域存储的是数据记录的地址(非聚集索引)
  ![](https://github.com/flushCoder/java-base_core/blob/master/picture/db/MyISAM.jpg)
