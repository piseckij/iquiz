package by.pisetskiy.iquiz.api.controller;

import static by.pisetskiy.iquiz.api.RestEndpoints.API_PREFIX;
import static by.pisetskiy.iquiz.api.RestEndpoints.POSITIONS;
import static by.pisetskiy.iquiz.util.IQuizUtil.map;

import by.pisetskiy.iquiz.api.dto.PositionDto;
import by.pisetskiy.iquiz.api.mapper.PositionMapper;
import by.pisetskiy.iquiz.api.request.PositionRequest;
import by.pisetskiy.iquiz.api.security.HasRoleAdmin;
import by.pisetskiy.iquiz.service.PositionService;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API_PREFIX + POSITIONS)
@RequiredArgsConstructor
@HasRoleAdmin
public class PositionController implements BaseController<PositionDto, PositionRequest> {

    private final PositionService service;
    private final PositionMapper mapper;

    @Override
    public List<PositionDto> findAll(Map<String, String> params) {
        var positions = service.findAll();
        return map(positions, mapper::toListDto);
    }

    @Override
    public PositionDto findById(Long id) {
        var position = service.findById(id);
        return mapper.toDetailDto(position);
    }

    @Override
    public PositionDto create(PositionRequest request) {
        var position = service.create(request);
        return mapper.toDetailDto(position);
    }

    @Override
    public PositionDto update(Long id, PositionRequest request) {
        var position = service.update(id, request);
        return mapper.toDetailDto(position);
    }

}
