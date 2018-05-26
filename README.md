# TGproject_flag
场地预约项目

> 临时域名： http://flagtestj.zhengsj.top
> 端口： 8004

```
.
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── ctg
    │   │           └── flag
    │   │               ├── config
    │   │               │   └── InterceptorConfig.java
    │   │               ├── dao
    │   │               │   ├── CouncilOrderDao.java
    │   │               │   ├── DepartmentDao.java
    │   │               │   ├── MessageDao.java
    │   │               │   ├── PlaceDao.java
    │   │               │   ├── PlaceOrderDao.java
    │   │               │   ├── SpaceApplyDao.java
    │   │               │   └── UserDao.java
    │   │               ├── enums
    │   │               │   ├── AdminKindEnum.java
    │   │               │   ├── CouncilStateEnum.java
    │   │               │   ├── DepartmentKindEnum.java
    │   │               │   ├── MessageKindEnum.java
    │   │               │   ├── MessageStateEnum.java
    │   │               │   ├── PlaceKindEnum.java
    │   │               │   ├── PlaceOrderStateEnum.java
    │   │               │   ├── ResponseStatusEnum.java
    │   │               │   ├── SpaceApplyStateEnum.java
    │   │               │   └── UserInfoStateEnum.java
    │   │               ├── exception
    │   │               │   ├── handler
    │   │               │   │   └── GlobalExceptionHandler.java
    │   │               │   ├── NoAuthenticationException.java
    │   │               │   └── NoPermissionException.java
    │   │               ├── FlagApplication.java
    │   │               ├── pojo
    │   │               │   ├── dto
    │   │               │   │   ├── CouncilOrderListDto.java
    │   │               │   │   ├── OptionDto.java
    │   │               │   │   ├── OrderManageDto.java
    │   │               │   │   ├── PlaceDetailDto.java
    │   │               │   │   ├── PlaceDto.java
    │   │               │   │   ├── PlaceOrderDetailDto.java
    │   │               │   │   ├── ResponseDto.java
    │   │               │   │   ├── SpaceApplyResponseDto.java
    │   │               │   │   └── TimeSlotDto.java
    │   │               │   └── entity
    │   │               │       ├── Admin.java
    │   │               │       ├── CouncilOrder.java
    │   │               │       ├── Department.java
    │   │               │       ├── Message.java
    │   │               │       ├── Place.java
    │   │               │       ├── PlaceOrder.java
    │   │               │       ├── SpaceApply.java
    │   │               │       └── User.java
    │   │               ├── service
    │   │               │   ├── CouncilOrderService.java
    │   │               │   ├── DepartmentService.java
    │   │               │   ├── impl
    │   │               │   │   ├── CouncilOrderServiceImpl.java
    │   │               │   │   ├── DepartmentServiceImpl.java
    │   │               │   │   ├── MessageServiceImpl.java
    │   │               │   │   ├── PlaceOrderServiceImpl.java
    │   │               │   │   ├── PlaceServiceImpl.java
    │   │               │   │   ├── SpaceServiceImpl.java
    │   │               │   │   └── UserServiceImpl.java
    │   │               │   ├── MessageService.java
    │   │               │   ├── PlaceOrderService.java
    │   │               │   ├── PlaceService.java
    │   │               │   ├── SpaceService.java
    │   │               │   └── UserService.java
    │   │               ├── util
    │   │               │   ├── DateUtil.java
    │   │               │   ├── JsonUtil.java
    │   │               │   ├── UUIDUtil.java
    │   │               │   └── WechatUtil.java
    │   │               └── web
    │   │                   ├── controller
    │   │                   │   ├── CouncilController.java
    │   │                   │   ├── CouncilOrderController.java
    │   │                   │   ├── DepartmentController.java
    │   │                   │   ├── MessageController.java
    │   │                   │   ├── PlaceController.java
    │   │                   │   ├── PlaceOrderController.java
    │   │                   │   ├── SpaceController.java
    │   │                   │   └── UserController.java
    │   │                   ├── filter
    │   │                   └── interceptor
    │   │                       └── UserInfoInterceptor.java
    │   └── resources
    │       ├── application.yml
    │       ├── import.sql
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
                └── ctg
                    └── flag
                        └── FlagApplicationTests.java

29 directories, 71 files
```