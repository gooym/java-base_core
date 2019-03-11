### 幂等定义
用户对同同意操作发起多次请求,对服务端结果的影响是不变的

### 解决幂等的方法

- 使用数据库的唯一约束  
  对关键字段设置唯一索引

- 状态机幂等   
  在设计单据相关的业务，或者是任务相关的业务，肯定会涉及到状态机(状态变更图)，就是业务单据上面有个状态，状态在不同的情况下会发生变更，一般情况下存在有限状态机，这时候，如果状态机已经处于下一个状态，
  这时候来了一个上一个状态的变更，理论上是不能够变更的，这样的话，保证了有限状态机的幂等。  
  核心SQL:    
  ```sql
    UPDATE table SET status = 下一种状态  
    WHERE id = #{id} AND status = 当前状态
  ```
- 基于**Redis**分布式锁  
  