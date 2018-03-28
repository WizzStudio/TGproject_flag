package com.ctg.flag.web.controller;

import com.ctg.flag.enums.AdminKindEnum;
import com.ctg.flag.enums.SpaceApplyStateEnum;
import com.ctg.flag.pojo.dto.ResponseDto;
import com.ctg.flag.pojo.dto.SpaceApplyResponseDto;
import com.ctg.flag.pojo.entity.SpaceApply;
import com.ctg.flag.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/space")
public class SpaceController {
    SpaceService spaceService;

    @Autowired
    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    /**
     * 判断用户是否存在未删除的入驻申请
     */
    @RequestMapping(value = "/apply/existence", method = RequestMethod.GET)
    public ResponseDto isExisted(HttpSession session) {
        Integer uid = (Integer) session.getAttribute("userId");
        Boolean existed = spaceService.existsByUidAndStateNot(uid, SpaceApplyStateEnum.DELETED.getValue());

        if (existed) {
            return ResponseDto.succeed();
        } else {
            return ResponseDto.failed();
        }
    }

    /**
     * 用户提交入驻申请
     */
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public ResponseDto postSpaceApply(SpaceApply spaceApply, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("userId");
        spaceApply.setAdminKind(AdminKindEnum.SPACE_APPLY_ADMIN.getValue());
        spaceApply.setUid(uid);
        spaceApply.setState(SpaceApplyStateEnum.PENDING.getValue());
        spaceService.saveSpaceApply(spaceApply);

        return ResponseDto.succeed();
    }

    /**
     * 获取用户申请状态
     */
    @RequestMapping(value = "/apply", method = RequestMethod.GET)
    public ResponseDto getSpaceApply(HttpSession session) {
        Integer uid = (Integer) session.getAttribute("userId");
        SpaceApply spaceApply = spaceService.getSpaceApplyByUid(uid);

        SpaceApplyResponseDto spaceApplyResponseDto = new SpaceApplyResponseDto();
        spaceApplyResponseDto.setFeedback(spaceApply.getFeedback());
        spaceApplyResponseDto.setState(spaceApply.getState());

        return ResponseDto.succeed(null, spaceApplyResponseDto);
    }
}
