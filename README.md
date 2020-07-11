# spring-project-integration
spring project integration

#### 项目组成模型
- project-root
    - project-demo
        - domain
            - project-component
            - project-component-dao
            - project-dto-share
        - scenario
            - project-scenario
            - project-scenario-share
            - project-spi
            - project-spi-share
        - project-app （application启动类）
    - project-demo2 (组成和demo类似)
 
 这个是一个application的项目多模块的组成模型，每个都是具体到项目粒度。
 
 `domain文件夹下的项目是供scenario调用，project-component是提供对scenario数据操作的接口，project-component-dao是提供数据库的DAO，project-dto-share是提供模型实体。`
 
 `scenario文件夹下的项目提供业务逻辑处理和对外接口，scenario层的内容不能被domain引用，实现了只能高层引用底层，底层不引用高层。project-scenario是提供内部业务逻辑，project-scenario-share提供对外接口，project-spi是引用feign调用或则外部调用接口，project-spi-share是给scenario层提供访问外部服务的接口。`
 
 
