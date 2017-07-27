# 开发指南

## 代码风格

本项目所有代码风格必须保持一致。代码风格可以参考阿里巴巴公开的Java开发手册，或其它流行的风格指南(例如google)。
特别地，Java代码使用4个空格代替一个Tab键。

## 事务处理

框架已经集成了事务的支持，开发时采用注解的方式开启事务即可。例如：

    # 接口定义
    public interface FooService {
        void foo() throws Exception;
        ...
    }
    
    # 接口实现
    public class FooServiceImpl implements FooService {
    
        @Transactional  // 开启事务
        @Override
        public void foo() throws Exception {
            数据库操作A
            数据库操作B
            数据库操作C
        }
        
        ...
    }

以上代码片段中：
- 在执行`foo`方法时，若存在数据库操作的失败，会自动回滚。
- 目前整个框架只支持单个数据库的事务。默认情况下，开启的事务指向`用户数据库`。
若要指向`基础数据库`，请在注解后面注明，例如：
```text
    Transactional(value = Constant.SYS_TRANSACTION_MGR)
```
- 不要在带事务注解的方法体内catch数据库操作的异常，这样做会使事务失效。例如：
```text
    @Transactional  // 开启事务
    @Override
    public void foo() throws Exception {
        try {
            数据库操作A
            数据库操作B
            数据库操作C
        } catch (Exception e) {
            ...
        }
    }
```