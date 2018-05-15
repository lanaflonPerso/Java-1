package photography.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import photography.serializers.Serializer;
import photography.services.MirrorlessService;

@Controller
public class MirrorlessController {

    private final Serializer jsonSerializer;
    private final Serializer xmlSerializer;
    private final MirrorlessService mirrorlessService;

    @Autowired
    public MirrorlessController(@Qualifier("json") Serializer jsonSerializer, @Qualifier("xml") Serializer xmlSerializer, MirrorlessService mirrorlessService) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.mirrorlessService = mirrorlessService;
    }
}
