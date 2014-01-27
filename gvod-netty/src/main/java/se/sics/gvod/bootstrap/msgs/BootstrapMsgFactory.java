package se.sics.gvod.bootstrap.msgs;

import io.netty.buffer.ByteBuf;
import java.util.List;
import java.util.Map;
import java.util.Set;
import se.sics.gvod.common.VodDescriptor;
import se.sics.gvod.common.msgs.MessageDecodingException;
import se.sics.gvod.common.msgs.DirectMsgNettyFactory;
import se.sics.gvod.net.msgs.DirectMsg;
import se.sics.gvod.net.util.UserTypesDecoderFactory;

public class BootstrapMsgFactory {

    public static class GetPeersRequest extends DirectMsgNettyFactory.Request {

        private GetPeersRequest() {
        }

        public static BootstrapMsg.GetPeersRequest fromBuffer(ByteBuf buffer) 
                
                throws MessageDecodingException {
            return (BootstrapMsg.GetPeersRequest) 
                    new BootstrapMsgFactory.GetPeersRequest().decode(buffer);
        }

        @Override
        protected BootstrapMsg.GetPeersRequest process(ByteBuf buffer) throws MessageDecodingException {
            int overlay = buffer.readInt();
            int utility = buffer.readInt();
            return new BootstrapMsg.GetPeersRequest(vodSrc, vodDest, 
                    overlay, utility);
        }
    }

    public static class GetPeersResponse extends DirectMsgNettyFactory.Response {

        private GetPeersResponse() {
        }

        public static BootstrapMsg.GetPeersResponse fromBuffer(ByteBuf buffer) 
                
                throws MessageDecodingException {
            return (BootstrapMsg.GetPeersResponse)
                    new BootstrapMsgFactory.GetPeersResponse().decode(buffer);
        }

        @Override
        protected BootstrapMsg.GetPeersResponse process(ByteBuf buffer) throws MessageDecodingException {
            int overlay = buffer.readInt();
            List<VodDescriptor> entries = 
                    UserTypesDecoderFactory.readListVodNodeDescriptors(buffer);
            return new BootstrapMsg.GetPeersResponse(vodSrc, vodDest, 
                    timeoutId, overlay, entries);
        }
    }

    public static class Heartbeat extends DirectMsgNettyFactory.Oneway {

        private Heartbeat() {
        }

        public static BootstrapMsg.Heartbeat fromBuffer(ByteBuf buffer) 
                
                throws MessageDecodingException {
            return (BootstrapMsg.Heartbeat) new BootstrapMsgFactory.Heartbeat().decode(buffer);
        }

        @Override
        protected BootstrapMsg.Heartbeat process(ByteBuf buffer) throws MessageDecodingException {
            short mtu = buffer.readShort();
            Set<Integer> seeders = UserTypesDecoderFactory.readSetInts(buffer);
            Map<Integer,Integer> downloaders = UserTypesDecoderFactory.readMapIntInts(buffer);
            return new BootstrapMsg.Heartbeat(vodSrc, vodDest, mtu, seeders, downloaders);
        }
    }
    
    public static class AddOverlayReq extends DirectMsgNettyFactory.Request {

        private AddOverlayReq() {
        }

        public static BootstrapMsg.AddOverlayReq fromBuffer(ByteBuf buffer) 
                throws MessageDecodingException {
            return  
                    (BootstrapMsg.AddOverlayReq) new BootstrapMsgFactory.AddOverlayReq().decode(
                    buffer);
        }

        @Override
        protected BootstrapMsg.AddOverlayReq process(ByteBuf buffer) throws MessageDecodingException {
            String overlayName = UserTypesDecoderFactory.readStringLength256(buffer);
            int overlayId = buffer.readInt();
            String description = UserTypesDecoderFactory.readStringLength256(buffer);
            byte[] torrentData = UserTypesDecoderFactory.readBytesLength65536(buffer);
            String imageUrl = UserTypesDecoderFactory.readStringLength256(buffer);
            int part = UserTypesDecoderFactory.readUnsignedIntAsOneByte(buffer);
            int numParts = UserTypesDecoderFactory.readUnsignedIntAsOneByte(buffer);
            return new BootstrapMsg.AddOverlayReq(vodSrc, vodDest, overlayName,
                    overlayId, description, torrentData, imageUrl, part, numParts);
        }
    }
    
    
    public static class AddOverlayResp extends DirectMsgNettyFactory.Response {

        private AddOverlayResp() {
        }

        public static BootstrapMsg.AddOverlayResp fromBuffer(ByteBuf buffer) 
                throws MessageDecodingException {
            return  
                    (BootstrapMsg.AddOverlayResp) new BootstrapMsgFactory.AddOverlayResp().decode(
                    buffer);
        }

        @Override
        protected BootstrapMsg.AddOverlayResp process(ByteBuf buffer) throws MessageDecodingException {
            int overlayId = buffer.readInt();
            boolean success = UserTypesDecoderFactory.readBoolean(buffer);
            boolean finished = UserTypesDecoderFactory.readBoolean(buffer);
            return new BootstrapMsg.AddOverlayResp(vodSrc, vodDest, overlayId, 
                    success, finished, timeoutId);
        }
    }    
    
};
