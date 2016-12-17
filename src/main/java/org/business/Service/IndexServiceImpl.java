package org.business.Service;

import org.business.Common.Out.Meta;
import org.business.Common.Out.Out;
import org.business.Common.Out.OutData;
import org.springframework.stereotype.Service;

/**
 * Created by wangz on 2016/12/17.
 */
@Service
public class IndexServiceImpl implements IndexService {


    @Override
    public Out getOut() {

        return new Out(Meta.Success);
    }

    @Override
    public Out getOutData() {
        return new OutData(Meta.Success,null);
    }
}
