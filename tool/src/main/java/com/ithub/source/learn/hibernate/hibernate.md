# hibernate 备注
[官方文档](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#preface)
#### validate 校验请求
*快速返回(一旦有错误就返回)*

    ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
        .configure()
        .failFast( true )
        .addMapping( (ConstraintMapping) null )
        .buildValidatorFactory();
    Validator validator = validatorFactory.getValidator();
